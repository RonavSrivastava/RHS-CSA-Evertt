public class FrameBuilding implements Runnable {

  String filePath = "";
  Img2Ascii Img2Ascii = new Img2Ascii();
  String curFrame = "";

  public FrameBuilding(String path) {
    this.filePath = path;
  }

  public void run() {
    this.curFrame = Img2Ascii.convertToAscii(this.filePath);
  }
}