package test;

import java.io.File;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;

public class UseDigesterExample {
	private static final Logger log = LoggerFactory.getLogger(UseDigesterExample.class);

  public void parse() {
    String path = System.getProperty("user.dir") + File.separator  + "etc";
    path = "C:/sp/work/eclipseWorkspace/tomcat/HowTomcatWorksProject/etc";
    File file = new File(path, "UseDigesterExample.xml");

    Digester digester = new Digester();
    try {
      Rule rule = new MyRule();
      digester.addRule("book", rule);
      //digester.addRule("a/b", rule);
      Object object = digester.parse(file);
      log.info("object = {}", object);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    UseDigesterExample digester = new UseDigesterExample();
    digester.parse();
  }
}


class MyRule extends Rule {
  public void begin(Attributes attributes) throws Exception {
    System.out.println("begin");
  }

  public void body(String text) throws Exception {
    System.out.println("body. Text:" + text);
  }

  public void end() throws Exception {
    System.out.println("end");
  }

  public void finish() throws Exception {
    System.out.println("finish");
  }

}
