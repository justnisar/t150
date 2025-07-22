package src;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;


// This is the HtmlParser's API interface.
  // You should not implement it, or speculate about its implementation
  interface HtmlParser {
     public List<String> getUrls(String url);

  }

class Solution {

    private Set<String> visitedUrls;
    private String startHostName;
    private HtmlParser htmlParser;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        this.htmlParser = htmlParser;
        this.visitedUrls = ConcurrentHashMap.newKeySet();
        this.startHostName = getHostName(startUrl);

        if(this.startHostName == null){
            return new ArrayList<>();
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(100);
        CrawlTask initialTask = new CrawlTask(startUrl);
        forkJoinPool.invoke(initialTask);

        return this.visitedUrls.stream().toList();
    }

    private String getHostName(String url){
        try{
            return new URL(url).getHost();
        }
        catch(MalformedURLException ex){
            return null;
        }
    }

    // We will define this worker class next.
    private class CrawlTask extends RecursiveAction {

        private final String url;

        public CrawlTask(String startUrl){
            this.url = startUrl;
        }

        @Override
        protected void compute() {

            if (!visitedUrls.add(this.url)) {
                return; // If add() returns false, another thread has already claimed this URL.
            }

            List<String> nextUrls = htmlParser.getUrls(url);
            List<CrawlTask> subTasks = new ArrayList<>();
            for(String nextUrl : nextUrls){
                if(startHostName.equals(getHostName(nextUrl))){
                    subTasks.add(new CrawlTask(nextUrl));
                }
            }
            invokeAll(subTasks);

        }
        // ...
    }
}
