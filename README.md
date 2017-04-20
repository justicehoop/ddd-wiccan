* 사용자 시나리오

광고주(업주)가 특정업소를 광고한다.
광고과금 방식은 선불제 CPT방식과 후불제 CPC방식이 있다.
광고상품은 울트라콜과 파워콜이 있다.
CPT상품의 기본 계약 기간은 30일이다

광고 환불 요청시 CPT상품의 경우 일할 계산하여 잔여 금액을 환불 한다.
광고 환불 요청시, 후불제 상품의 경우 환불하지 않는다.

광고 신청은 카드나 은행계좌를 등록하여 특정 결제일에 광고 금액을 지불한다.
은행계좌는 저장하여 정기결제일에 결제정보로 활용 한다.
카드 정보는 남기지 않으며 BillKey를 PG사로부터 발급 받아서 관리한다.

일반광고는 시작일이 결제일 기준으로 광고가 시작 된다.
빠른광고 신청은 광고비 입금 후 익일 부터 광고가 시작 된다.

* common
서브 프로젝트에서 공통적으로 사용할 Entity 및 라이브러리 (Domain Event Pub/Sub기능 제공)

* wiccan-management
광고 구매 및 상태 관리(backoffice) business logic 제공

* wiccan-management-api
광고 구매 상태 관리(backoffice) api business logic 제공

* wiccan-impression
광고노출 api 서버

* wiccan-impression
messaging queue를 이용해 pub/sub 기능을 제공