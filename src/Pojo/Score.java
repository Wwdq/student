package Pojo;

public class Score
{  private  int id;
   private  int eno;
   private  String sno;
   private  int sc;
   private Exam exam;
   private double bai;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getEno() {
      return eno;
   }

   public void setEno(int eno) {
      this.eno = eno;
   }

   public String getSno() {
      return sno;
   }

   public void setSno(String sno) {
      this.sno = sno;
   }

   public int getSc() {
      return sc;
   }

   public void setSc(int sc) {
      this.sc = sc;
   }

   public Exam getExam() {
      return exam;
   }

   public void setExam(Exam exam) {
      this.exam = exam;
   }

   public double getBai() {
      return bai;
   }

   public void setBai(double bai) {
      this.bai = bai;
   }
}
