public class HelloThread extends Thread
{
    private String hello = "Hello";
    private int pause;
    
    public void run()
    {
        for (int i = 0; i < 5; i++) {
            try {
            pause = (int)(Math.random()*3000);
            sleep(pause);
            System.out.println(hello);
            }
            catch (InterruptedException iEx) {
                System.out.println(iEx);
            }
        }
    }

}
