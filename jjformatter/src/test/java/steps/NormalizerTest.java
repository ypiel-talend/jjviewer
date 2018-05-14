package steps;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;

public class NormalizerTest {

    @Test
    public void normalierSimpleJavaJet() {
        try {
            ClassLoader loader = getClass().getClassLoader();
            InputStream is = loader.getResourceAsStream("samples/simple.javajet");
            String simple_java = IOUtils.toString(is, StandardCharsets.UTF_8);

            InputStream isol = loader.getResourceAsStream("samples/simple_normalized.javajet");
            String ref_normalized_java = IOUtils.toString(isol, StandardCharsets.UTF_8);

            Normalizer n = new Normalizer(simple_java);
            String normalized_java = n.format();

            FileWriter fw = new FileWriter("c:/temp/normalized.javajet");
            fw.write(normalized_java);
            fw.close();

            assertTrue(ref_normalized_java.equals(normalized_java));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void normalierSimpleClassWithComments() {
        try {
            ClassLoader loader = getClass().getClassLoader();
            InputStream is = loader.getResourceAsStream("samples/SimpleClassWithComments.java");
            String simple_java = IOUtils.toString(is, StandardCharsets.UTF_8);

            InputStream isol = loader.getResourceAsStream("samples/SimpleClassWithComments_normalized.java");
            String ref_normalized_java = IOUtils.toString(isol, StandardCharsets.UTF_8);

            Normalizer n = new Normalizer(simple_java);
            String normalized_java = n.format();

            FileWriter fw = new FileWriter("c:/temp/normalierSimpleClassWithComments.java");
            fw.write(normalized_java);
            fw.close();

            assertTrue(ref_normalized_java.equals(normalized_java));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void normalierSimpleClass() {
        try {
            ClassLoader loader = getClass().getClassLoader();
            InputStream is = loader.getResourceAsStream("samples/SimpleClass.java");
            String simple_java = IOUtils.toString(is, StandardCharsets.UTF_8);

            InputStream isol = loader.getResourceAsStream("samples/SimpleClass_normalized.java");
            String ref_normalized_java = IOUtils.toString(isol, StandardCharsets.UTF_8);

            Normalizer n = new Normalizer(simple_java);
            String normalized_java = n.format();

            FileWriter fw = new FileWriter("c:/temp/normalierSimpleClass.java");
            fw.write(normalized_java);
            fw.close();

            assertTrue(ref_normalized_java.equals(normalized_java));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @Test
    public void jjNormalized() {
        try {
            ClassLoader loader = getClass().getClassLoader();
            InputStream is = loader.getResourceAsStream("javajet/tVerticaBulkExec_begin.javajet");
            String jjsrc = IOUtils.toString(is, StandardCharsets.UTF_8);

            InputStream isol = loader.getResourceAsStream("javajet/ref/tVerticaBulkExec_begin_oneLine.javajet");
            String oneLineRef = IOUtils.toString(isol, StandardCharsets.UTF_8);

            Normalizer n = new Normalizer(jjsrc);
            String oneLine = n.format();

            assertTrue(oneLineRef.equals(oneLine));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}