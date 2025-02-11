package hw0207;

public class ParameterUtil {
	/**
	 * 전달된 파라미터 중에 최소 하나라도 비어있다면 true 를 반환시킨다.
	 * @param param 가변파라미터
	 * @return
	 */
	public static boolean isEmptyLeastOne(String ... param) {
		if (param == null) {
			return true;
		}
		
		for (int i = 0; i < param.length; i++) {
			if ( param[i] == null || param[i].isEmpty() ) {
				return true;
			}
		}
		return false;
	}
}
