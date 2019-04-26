package Pojo;

import java.util.ArrayList;
import java.util.List;

public class Exam {
  private  int eno;
  private   String estring;
  private  int cno;
  private  String cname;
  private Grade grade;
  private List<Student> students;
  private List<Score>  scores=new ArrayList<>();
  private ScoreTip scoreTip;
  public Exam() {
  }

  public int getEno() {
    return eno;
  }

  public void setEno(int eno) {
    this.eno = eno;
  }

  public String getEstring() {
    return estring;
  }

  public void setEstring(String estring) {
    this.estring = estring;
  }

  public int getCno() {
    return cno;
  }

  public void setCno(int cno) {
    this.cno = cno;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public List<Score> getScores() {
    return scores;
  }

  public void setScores(List<Score> scores) {
    this.scores = scores;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }

  public ScoreTip getScoreTip() {
    return scoreTip;
  }

  public void setScoreTip(ScoreTip scoreTip) {
    this.scoreTip = scoreTip;
  }
}
