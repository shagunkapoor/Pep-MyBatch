//package Z_Interviews.Airtel.src.test.java;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BrowserHistoryTest {
//    BrowserHistory browserHistory=new BrowserHistory();
//
//    it("should print browser history",()=>{
//        browserHistory.push(new Url("Test-URL"));
//        browserHistory.printUrls();
//        assertEquals(document).contains("Test-URL");
//    });
//
//    @Test
//    public void shouldBeAbleToPushUrlToBrowserHistory(){
//        browserHistory.push(new Url("Test-URL"));
//        browserHistory.push(new Url("Test-URL-1"));
//        assertEquals(2, browserHistory.getUrlHistoryCount());
//    };
//
//    @Test
//    public void shouldReturnZeroWhenNoUrlIsPresentInHistory(){
//        assertEquals(0, browserHistory.getUrlHistoryCount());
//    };
//
//    @Test
//    public void shouldReturnTheLatestUrlFromBrowserHistory(){
//        browserHistory.push(new Url("Test-URL-1"));
//        browserHistory.push(new Url("Test-URL-2"));
//        assertEquals("Test-URL-2", browserHistory.pop().domainName);
//    };
//
//    @Test
//    public void shouldReturnNullWhenBrowserHistoryIsEmpty(){
//        assertEquals(null, browserHistory.pop());
//    };
//
//}
