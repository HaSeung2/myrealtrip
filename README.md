# myrealtrip
프로젝트 소개
--
먼저 우리가 작성 한 코드의 흐름은 아래의 내용을 참고하면 된다. 첫 페이지를 작성할 때 들어간 로직프로세스인데 다른 서브페이지도 아래와 같이 작성하였다.
코드를 하나씩 작성해보면 좋겠지만 생각보다 양이 방대해져서 핵심 컨셉이였던 API와 swiper 사용을 위주로 설명 할 것이다.
--
### 전체적인 구성

![68747470733a2f2f76656c6f672e76656c63646e2e636f6d2f696d616765732f6b6d323533352f706f73742f33376637653635332d633639612d343437322d396439652d6439333539306637303261362f696d6167652e706e67](https://user-images.githubusercontent.com/108933977/178207006-e77df570-00b8-4f95-b6a6-a8f800a9ae2f.png)
### 실시간 항공권 API
글을 작성하면서 우리의 핵심 컨셉을 설명하지 않을 수 없다. 실제 사이트에서는 방대한 데이터를 가지고 페이지를 구성하였는데 가장 큰 고민은 항공권을 어떻게 받아올지가 가장 큰 고민이였다.

우리의 데이터베이스에 직접 이 데이터들을 집어넣을까 고민도 했지만 핵심 컨셉을 유지하기 위해서는 새로운 것을 적용해 볼 수 밖에 없었다.

공공데이터 포탈을 활용하여 데이터를 받아오기로 결정하여 api key를 받아 실시간 운항계획을 받아왔다.

막상 url을 요청하고 데이터는 받기 쉬워도 이 데이터를 어떻게 풀어서 우리 프로젝트에 어떻게 녹여낼지가 매우 큰 숙제가 되었다.

데이터 받아오기
json이 아닌 xml의 형태의 데이터를 받아온다. dao 클래스에 정의
```java
public NodeList getAirAPI() {
try {
//document instance를 생성
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
// 인스턴스의 메소드를 실행, 이 빌더를 통해 xml로 가져온 데이터를 document타입으로 가공한다.
DocumentBuilder builder = factory.newDocumentBuilder();
//buffer타입의 객체를 생성하고 
StringBuffer pharm_url = new StringBuffer();
//가져오고자 하는 요청 주소를 append한다.
pharm_url.append("http://openapi.airport.co.kr/service/rest/FlightStatusList/getFlightStatusList");
pharm_url.append("?ServiceKey=[서비스키]");
pharm_url. append("&schAirCode=GMP");
//URL 객체로 해당 stringbuffer를 넘겨주고
URL url = new URL(pharm_url.toString());
//bufferinputStream객체로 생성하면 가져오기 완료
BufferedInputStream xmldata = new BufferedInputStream(url.openStream());

//가져온 데이터는 builder를 통해 parse메소드로 넘겨주면 document타입이 된다. 
Document document = builder.parse(xmldata);
//xml의 요소를 가져오려면 getDocumentElement메소드를 사용한다.
Element root = document.getDocumentElement();
//xml의 요소는 node요소이다. 우리가 원하는 데이터들은 xml의 item에 들어있으니 NodeList 객체 타입으로 list변수에 넣어주자.
NodeList list = root.getElementsByTagName("item");
//우리의 정보가 들어있는 list를 리턴하면 끝.
return list;
// 아래는 실패했을 경우 처리하는 catch문이다. 
} catch (MalformedURLException e) {
e.printStackTrace();
} catch (ParserConfigurationException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (SAXException e) {
e.printStackTrace();
}
//데이터가 없다면 null을 반환한다. 
return null;
}
```
데이터 가공하기 데이터를 NodeList로 받아왔다. 그 과정이 쉽지 않았지만 여러 데이터들을 하나의 묶음으로 가져올 수 있었다. 대신 번거롭게 생성하는 객체들이 많았고 이렇게 가져올 수 도 있지만 아마 더 효율적인 방법이 존재할 것이다.

아래의 코드는 NodeList로 받아온 항공권에 대해서만 가공한 코드를 발췌한 것이다.
```java
// dao를 통해 데이터를 받아 왔으니 필요함
AirDAO adao = new AirDAO();
// 해당 메소드를 실행하면 NodeList타입으로 받아오게 됨.
NodeList nodelist = adao.getAirAPI();
//List타입의 Map형태의 객체를 넣는 변수를 만든다. 
List<Map<String, Object>> list  = new ArrayList<>();
// map타입으로 각각의 데이터를 넣기 때문에 해당 변수를 만든다.
Map<String, Object> map = null;
//NodeList의 길이만큼 반복시켜서 노드들을 가져온다.
// [{key : value, key : value...},{key : value, key : value...},
//{key : value, key : value...},{key : value, key : value...}.......]
for (int i = 0; i < nodelist.getLength(); i++) {
//새로운 HashMap을 만들어 map에 넣을 준비를 한다. 
map = new HashMap<>();

//노드에 있는 item의 자식요소를 가져온다
//({key : value, key : value ..})
Node node = nodelist.item(i);
NodeList item_childlist = node.getChildNodes();
// 가져온 자식 요소의 길이 만큼 반복시키면 자식 요소 안의 
// 모든 데이터들을 가져 올 수 있다. 
  for (int j = 0; j < item_childlist.getLength(); j++) {
// 자식 요소의 item 안에 비로소 우리가 원하는 데이터가 존재한다. 
    Node item_childe = item_childlist.item(j);
// 아래와 같이 조건문으로 우리가 원하는 데이터를 별도로 뽑아낼 수 있다. 
    if(item_childe.getNodeName().equals("etd")) { 
//별도로 뽑아낸 데이터는 우리가 원하는 key네임으로 저장할 수 있다.
      map.put("fEtd", item_childe.getTextContent().substring(0,2)); 
      map.put("bEtd", item_childe.getTextContent().substring(2,4));
    }else {
// 나머지 데이터도 노드네임을 key로 노드value를 value로 map에다가 넣어주자
      map.put(item_childe.getNodeName(), item_childe.getTextContent()); 
    }
  }
//여기까지 실행되면 map에 키-값 구조로 담긴 데이터가 hashMap으로 존재한다.
//리스트로 만들어서 map을 저장할 수 있다. 
  list.add(i,map);
}
// setAttribute로 list를 담자. 
req.setAttribute("list", list);
// 이하 설명 생략. 
ActionTo acto = new ActionTo();
acto.setRedirect(false);
acto.setPath("/app/air/airlist.jsp");
return acto;
}
```
#### 받아온 실제 데이터(xml)
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<response>
  <header>
    <resultCode>00</resultCode>
    <resultMsg>NORMAL SERVICE.</resultMsg>
  </header>
  <body>
    <items>
// Node node = nodelist.item(i) item 태그를 포함하여 가져옴
      <item>
//NodeList item_childlist = node.getChildNodes(); 형제 노드들을 모두 가져옴. 그래서 노드 리스트 타입임. 
//길이가 안에 있는 태그들의 갯수임. 
        <airFln>RS901</airFln>
  // 여기 태그부터 설명하겠음, 
 //Node item_childe = item_childlist.item(1);
// 해당되는 item의 인덱스 번호 1이라 위와 같이 작성함.
// item_childe.getNodeName() -> airlineEnglish
//item_childe.getTextContent() -> AIR SEOUL
        <airlineEnglish>AIR SEOUL</airlineEnglish>
        <airlineKorean>에어서울</airlineKorean>
        <airport>GMP</airport>
        <arrivedEng>JEJU</arrivedEng>
        <arrivedKor>제주</arrivedKor>
        <boardingEng>GIMPO</boardingEng>
        <boardingKor>서울/김포</boardingKor>
        <city>CJU</city>
        <etd>0612</etd>
        <flightDate>2022/06/29</flightDate>
        <gate>20</gate>
        <io>O</io>
        <line>국내</line>
        <rmkEng>DEPARTED</rmkEng>
        <rmkKor>출발</rmkKor>
        <std>0600</std>
      </item>
      <item>
        ....내용 생략
      </item>
    </items>
    <numOfRows>10</numOfRows>
    <pageNo>1</pageNo>
    <totalCount>1410</totalCount>
  </body>
</response>
```
### swiper.js
Swiper.js 란 React, Vue, Angular, Svelte 등 다양한 프레임워크에서 이미지나 페이지의 슬라이딩 혹은 스와이핑을 역동적으로 사용할 수 있게 도와주는 라이브러리이다.
 페이지에 Navigation 기능을 이용한 이미지 슬라이더를 만들기 위한 라이브러리로 Swiper.js를 사용했다. 이를 최소한의 코드로 요약하여 적어보려한다.
 ```jsp
 <div class="swiper swiper-initialized risingHotel swiper-initializedse swiper-pointer-events">
  <div class="swiper-wrapper">
  <c:forEach items="${hotelspecialList}" var="sen">
    <div class="swiper-slide swiper-slide-active">
     <a class="ProductCard-Container" href="${cp}/loading/reserve.rs?datefilter=${param.datefilter}&hotelnum=${sen.up_sugso_num}&hotelname=${sen.sugso_name}&hotelImg=${sen.img_url}&hotelPrice=${sen.price}">
     <div class="ProductCard-image">
      <img class="css-y5m0bt" src="${sen.img_url}">
     </div> 
    <div class="ProductCard-Content"">
     <p class="ProductCard-Category">${sen.category}</p>
     <p class="ProductCard-Name">${sen.sugso_name}</p>
     <div class="ReviewRatingCount">
      <img class="css-labkkb" src="${sen.icon_img}" alt="icon">
       <p class="RatingCount-Rating">${sen.rating}</p>
       <p class="RatingCount-Count">${sen.count}</p>
     </div>
       <p class="ProductCard-Price">${sen.price}</p>
    </div> 
     </a>
  </div>
  </c:forEach>
 </div>
</div>
<button type="button" class="hotelspecialList-button-prev">
 <img src="${cp}/app/img/arrow_prev.svg">
</button>
<button type="button" class="hotelspecialList-button-next">
 <img src="${cp}/app/img/arrow_next.svg"> 
</button>
</div>
 ```
 ```js
 //css 선택자를 그대로 사용하면 된다. swiper의 최상위 선택자인 swiper를 사용했다.
const swiper = new Swiper(".Best > .swiper", {
// 한페이지에 보여 줄 슬라이드의 갯수이다. 
slidesPerView: 7,
// 다음 버튼을 누르면 한개씩 움직임으로 그룹을 1개로 잡았다. 
slidesPerGroup: 1,
// 버튼은 조작하기 위해 button의 클래스를 아래와 같이 적었다.
navigation: {
nextEl: ".hotelsugsoList-button-next",
prevEl: ".hotelsugsoList-button-prev",
},
});
 ```
