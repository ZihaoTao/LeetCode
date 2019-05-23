public class TwitterTest {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }
}
