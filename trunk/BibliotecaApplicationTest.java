public class BibliotecaApplicationTest  {

    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;
    BibliotecaApp bibliotecaApp;


    @Before
    public void before(){

        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));

        bibliotecaApp = new BibliotecaApp();

    }

    @Test
    public void shouldSeeWelcomeMessageWhenTheApplicationStarts(){
        bibliotecaApp.welcomeMessage();
        Assert.assertEquals("Welcome to our Library\n", byteArrayOutputStream.toString());
    }
}