package multi.semaphore.fileDownloader;

import java.util.concurrent.Semaphore;

public class FileDownloader implements Runnable{

    private String fileUrl;
    private static Semaphore semaphore = new Semaphore(10);

    public FileDownloader(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void download() throws InterruptedException {
        System.out.println("Starting download from " + fileUrl);
        Thread.sleep((int)(Math.random() * 1000));
        System.out.println("Completed download from " + fileUrl);
    }
}
