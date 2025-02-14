package hw0213;

public interface ContactAppInterface {

	/**
	 * 파일에서 데이터를 조회해 this.contacts 에 addAll 한다.
	 * @param fileDirectoryPath 저장된 연락처가 있는 파일의 폴더 경로
	 * @param filename 저장된 연락처가 있는 파일의 이름
	 */
	public void loadData(String fileDirectoryPath, String filename);
	
	/**
	 * 연락처 데이터를 파일에 쓴다.
	 * @param fileDirectoryPath 연락처를 저장할 폴더의 경로
	 * @param filename 연락처를 저장할 파일의 이름
	 */
	public void writeData(String fileDirectoryPath, String filename);

	public void remove(int contactIndex);
	public void clean();
	public void addNewContact(Contact contact);
	public Contact getContactAt(int contactIndex);
	public void sort();
}
