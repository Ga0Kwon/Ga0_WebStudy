package Day20.gallery.model.dao;

public class BoardDao extends Dao{
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return dao;
	}
}
