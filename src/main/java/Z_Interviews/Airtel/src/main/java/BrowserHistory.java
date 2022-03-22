//package Z_Interviews.Airtel.src.main.java;
//
//import java.util.Arrays;
//
//public class BrowserHistory {
//    private Url[] urls;
//    private int urlSize;
//    private int capacity = 100;
//    private CustomIterator iterator;
//
//    public BrowserHistory() {
//        urls = new Url[capacity];
//        iterator = new CustomIterator(urls);
//    }
//
//    public void printUrls() {
//        while (iterator.hasNext()) {
//            try {
//                System.out.println(iterator.next());
//            } catch (NoNextElementFoundException e) {
//                System.out.println("NoNextElementFoundException Error: ", e.printStackTrace());
//            }
//        }
//    }
//
//    public void push(Url url) {
//        //Out of size
//        if (urlSize >= capacity) {
//            incrementUrlCapacity();
//        }
//        urlSize += 1;
//        urls[urlSize] = url;
//    }
//
//    public Url pop() {
//        Url removedUrl = urls[urlSize];
//        urls[urlSize] = null;
//        urlSize--;
//
//        return removedUrl;
//    }
//
//    public int getUrlHistoryCount(){
//        return urlSize;
//    }
//
//    private void incrementUrlCapacity() {
//        capacity = capacity * 2;
//        Url[] newHistory = Arrays.copyOf(urls, capacity);
//        urls = newHistory;
//    }
//
//
//}
//
