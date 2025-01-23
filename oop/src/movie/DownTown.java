package movie;

public class DownTown {
	
	public static void main(String[] args) {
	
		// new -> 새로운 Theater 변수를 만듦
		Theater cgv = new Theater();
		// System.out.println(cgv);
		// -> 이렇게 하면 출력결과 - movie.Theater@5305067a
		
		Movie 하얼빈 = new Movie();
		하얼빈.title = "하얼빈";
		하얼빈.runningTime = 120;
		
		Seat h6 = new Seat(); 
		h6.seatNumber = "h6";
		h6.isFold = true;
		
		Speaker harman = new Speaker();
		harman.isOn = false;
		harman.volume = 50;
		
		Airconditioner carrier = new Airconditioner();
		// 기본값으로 둘 수도 있음
		
		Projector miniBeam = new Projector();
		miniBeam.isOn = true;
		
		Light sony = new Light();
		sony.color = "대충 노란색";
		sony.isOn = true;
		
		cgv.movie = 하얼빈;
		cgv.seat = h6;
		cgv.speaker = harman;
		cgv.light = sony;
		cgv.airconditioner = carrier;
		cgv.projector = miniBeam;
		
		cgv.playMovie();
		cgv.playMovie();
		
		cgv.turnOnAirConditional();
		cgv.turnOnAirConditional();
		
		cgv.turnOnLight();
		cgv.turnOnLight();
		
		cgv.controlVolume(50);
		cgv.controlVolume(60);
		cgv.controlVolume(-70);
		cgv.controlVolume(-50);
		
		cgv.controlSeat();
		cgv.controlSeat();
	}
}
