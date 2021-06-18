package StaticProxy;

public class TeacherDaoProxy implements ITeacherDao{
  private ITeacherDao teacherDao;

  public TeacherDaoProxy(ITeacherDao teacherDao) {
    this.teacherDao = teacherDao;
  }

  @Override
  public void teach() {
    System.out.println("老师授课准备中...");
    teacherDao.teach();
    System.out.println("老师授课结束了....");
  }
}
