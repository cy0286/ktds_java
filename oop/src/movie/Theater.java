package movie;

public class Theater {

//  속성 (상영관이 가지고 있는것들)
//  클래스 만들고 해당 클래스의 타입 변수 만들 수 있음
//	영화정보 - 영화제목, 러닝타임
	Movie movie;
	
//	좌석정보 - 번호, 상태
	Seat seat; 
	
//	스피커정보 - 볼륨, 전원여부
	Speaker speaker;
	
//	조명정보 - 색깔, 전원여부
	Light light;
	
//	에어컨정보 - 전원여부, 세기, 현재온도, 목표온도, 난방/냉방 여부
	Airconditioner airconditioner;
	
//	프로젝터 정보 - 전원여부, 재생여부
	Projector projector;
	
//  기능 (행동) - 상영관이 할 수 있는 것들
//	클래스 내부에서 행동을 위한 메소드를 만들 때는 static 을 쓰지 않음
// 	멤버 변수를 정의하면, 그 변수의 쓰임새가 있어야 함

// 	1. 영화 재생하기
//	- projector 변수의 isOn 값이 false 라면 isOne 값을 true 로 변경
// 	- projector 변수의 isOn 값이 true 일 때만 isPlay 값을 true 로 변경
//    projector 변수의 isPlay 값을 true 라면 "영화의 제목을 러닝타임동안 재생합니다" 라고 출력	
//	- projector 변수의 isPlay 값과 isOn 값을 false 로 변경
	public void playMovie() {
		if (! projector.isOn) {
			projector.isOn = true;
		}
		if (projector.isOn) {
			projector.isplay = true;
			
			if (projector.isplay) {
				System.out.println(movie.title + "을" + 
						movie.runningTime + "분 동안 재생합니다.");
				projector.isOn = false;
				projector.isplay = false;
			}
		}
	}
	
//	2. 에어컨 켜기
//	- airConditional 의 isOn 값이 false 라면 true 로 바꾸기
//		- 현재온도, 세기, 냉/난방 여부, 설정온도 할당
	public void turnOnAirConditional() {
		if (! airconditioner.isOn) {
			airconditioner.isOn = true;
			
			airconditioner.nowTemperature = (float) (Math.random() * 40);
			airconditioner.windSpeed = (int) (Math.random() * 4); // 0 ~ 3
			airconditioner.aimTemperature = (float) (Math.random() * 40);
			
			boolean isNowWinter = airconditioner.nowTemperature < airconditioner.aimTemperature;
			airconditioner.isCooling = !isNowWinter;
		}
	}
	
// 	3. 조명 끄고 켜기
//	- light 의 isOn 값이 false 라면 true 로 바꿔주고, true 라면 false 로 바꿈
//	- light 의 isOn 값이 true 라면 light 의 color 를 지정해줌
//	- light 의 isOn 값이 false 라면 light 의 color 를 null 로 변경함 ex) color = null;
//	- color 를 지정하는 방법:
//		- 0 ~ 2 중의 임의의 난수를 받아서 0이면 "RED", 1이면 "BLUE", 2이면 "GREEN" 으로 지정		
	public void turnOnLight() {
		if(! light.isOn) {
			light.isOn = true;

			if(light.isOn) {
				int color = (int) (Math.random() * 3);
				if (color == 0) {
					light.color = "RED";
				}
				else if (color == 1) {
					light.color = "BLUE";
				}
				else {
					light.color = "GREEN";
				}
			}
		}
		else {
			light.isOn = false;
			if (!light.isOn) {
				light.color = null;
			}
		}
	}

// 	4. 볼륨 조절하기
//	- speaker 의 isOn 값이 false 라면 true 로 변경
//	- speaker 의 isOn 값이 true 일때만 volume 이 변경됨
//	- volume 이 변경되는 방식:
//		- 숫자(정수)를 파라미터로 받아와서 volume 에 더해 할당하거나 뺌 (양수면 더해주고 음수면 빼줌)
//		- 증가하거나 감소할 때의 조건:
//			- 증가된 볼륨의 값이 100 초과된다면 100으로 변경
//			- 증가된 볼륨의 값이 0 미만이라면 0으로 변경
	public void controlVolume(int number) {
		if(!speaker.isOn) {
			speaker.isOn = true;
		}
		if(speaker.isOn) {
			speaker.volume += number;
			
			if (speaker.volume > 100) {
				speaker.volume = 100;
			}
			else if (speaker.volume < 0) {
				speaker.volume = 0;
			}
		}
	}
	
// 	5. 의자 조정하기 (접고 펴기)
//	- seat 변수의 isFold 값이 true 라면 false 로 바꾸고, false 라면 true 로 바꿈 (토글)
//	- 변경된 seat 변수의 isFold 값이 true 라면 "좌석번호가 접혔습니다." 라고 출력
//	  false 라면 "좌석번호가 펼쳐졌습니다."라고 출력
	public void controlSeat() {
		seat.isFold = !seat.isFold;
		
		if (seat.isFold) {
			System.out.println(seat.seatNumber + "가 접혔습니다.");
		}
		else {
			System.out.println(seat.seatNumber + "가 펼쳐졌습니다.");
		}
	}
}
