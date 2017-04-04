* management-service
DA, DA Group 관리, DA마다 배달권역, DA Group마다 관리 권역을 관리한다.
* delivery-service
배달, 배달 내역, 배달시 요금제, 라이더 할당을 수행하고, 정보를 제공한다.
* relayorder-service
* rider-service

모든 서비스에 entity를 포함 한다. 이후 entity를 분리 할수도 있다.(API로 연동한다면 response타입으로 분리해서 API로 제공해야한다. 하지만 과연 그럴까?)
entity가 설계된후 각 서비스에서 제공할 여러가지 Service package들을 정리해보자.# ddd-wiccan
