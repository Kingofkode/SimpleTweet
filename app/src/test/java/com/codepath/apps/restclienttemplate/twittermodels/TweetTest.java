package com.codepath.apps.restclienttemplate.twittermodels;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class TweetTest {

    // Tweet Class

    @Test
    public void tweetFromJson() {
        try {
            // Initialize tweet using code
            JSONObject jsonObject = new JSONObject("{\"created_at\":\"Thu Jul 02 18:33:00 +0000 2020\",\"id\":1278758589801299968,\"id_str\":\"1278758589801299968\",\"full_text\":\"RT @eldereats: \uD83C\uDF53 Tres. Leches. Croissant! \uD83D\uDE2E\\n@breadcultura - This is the tres leches croissant - a Hispanic influenced French dessert that i…\",\"truncated\":false,\"display_text_range\":[0,140],\"entities\":{\"hashtags\":[],\"symbols\":[],\"user_mentions\":[{\"screen_name\":\"eldereats\",\"name\":\"David Elder | KSAT 12 News\",\"id\":757991190021144576,\"id_str\":\"757991190021144576\",\"indices\":[3,13]},{\"screen_name\":\"breadcultura\",\"name\":\"La Panadería\",\"id\":2207516587,\"id_str\":\"2207516587\",\"indices\":[44,57]}],\"urls\":[]},\"source\":\"<a href=\\\"http:\\/\\/www.socialnewsdesk.com\\\" rel=\\\"nofollow\\\">SocialNewsDesk<\\/a>\",\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":16425419,\"id_str\":\"16425419\",\"name\":\"KSAT 12\",\"screen_name\":\"ksatnews\",\"location\":\"San Antonio, TX\",\"description\":\"News from KSAT12 and https:\\/\\/t.co\\/yaXt175o3E; also see https:\\/\\/t.co\\/q7pZinCupI and follow @ksatweather for weather updates.\",\"url\":\"https:\\/\\/t.co\\/6B25Lgw6Of\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"https:\\/\\/t.co\\/6B25Lgw6Of\",\"expanded_url\":\"http:\\/\\/www.ksat.com\",\"display_url\":\"ksat.com\",\"indices\":[0,23]}]},\"description\":{\"urls\":[{\"url\":\"https:\\/\\/t.co\\/yaXt175o3E\",\"expanded_url\":\"http:\\/\\/ksat.com\",\"display_url\":\"ksat.com\",\"indices\":[21,44]},{\"url\":\"https:\\/\\/t.co\\/q7pZinCupI\",\"expanded_url\":\"https:\\/\\/www.facebook.com\\/KSAT12\\/\",\"display_url\":\"facebook.com\\/KSAT12\\/\",\"indices\":[55,78]}]}},\"protected\":false,\"followers_count\":247984,\"friends_count\":861,\"listed_count\":1230,\"created_at\":\"Tue Sep 23 20:59:32 +0000 2008\",\"favourites_count\":1159,\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"verified\":true,\"statuses_count\":210170,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"is_translation_enabled\":false,\"profile_background_color\":\"730202\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/459330122974117888\\/1iltsZnK_normal.jpeg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/459330122974117888\\/1iltsZnK_normal.jpeg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/16425419\\/1488216254\",\"profile_link_color\":\"870000\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"DDFFCC\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"has_extended_profile\":false,\"default_profile\":false,\"default_profile_image\":false,\"following\":true,\"follow_request_sent\":false,\"notifications\":false,\"translator_type\":\"regular\"},\"geo\":null,\"coordinates\":null,\"place\":null,\"contributors\":null,\"retweeted_status\":{\"created_at\":\"Thu Jul 02 17:33:17 +0000 2020\",\"id\":1278743561853440008,\"id_str\":\"1278743561853440008\",\"full_text\":\"\uD83C\uDF53 Tres. Leches. Croissant! \uD83D\uDE2E\\n@breadcultura - This is the tres leches croissant - a Hispanic influenced French dessert that is loaded with three milks including mascarpone cheese - strawberries make this pastry insanely delicious!\\n#eldereats https:\\/\\/t.co\\/09i5vvJPrZ\",\"truncated\":false,\"display_text_range\":[0,240],\"entities\":{\"hashtags\":[{\"text\":\"eldereats\",\"indices\":[230,240]}],\"symbols\":[],\"user_mentions\":[{\"screen_name\":\"breadcultura\",\"name\":\"La Panadería\",\"id\":2207516587,\"id_str\":\"2207516587\",\"indices\":[29,42]}],\"urls\":[],\"media\":[{\"id\":1278743550218231808,\"id_str\":\"1278743550218231808\",\"indices\":[241,264],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/Eb8Ce92UYAA3Zri.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/Eb8Ce92UYAA3Zri.jpg\",\"url\":\"https:\\/\\/t.co\\/09i5vvJPrZ\",\"display_url\":\"pic.twitter.com\\/09i5vvJPrZ\",\"expanded_url\":\"https:\\/\\/twitter.com\\/eldereats\\/status\\/1278743561853440008\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"small\":{\"w\":544,\"h\":680,\"resize\":\"fit\"},\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":960,\"h\":1200,\"resize\":\"fit\"},\"large\":{\"w\":1638,\"h\":2048,\"resize\":\"fit\"}}}]},\"extended_entities\":{\"media\":[{\"id\":1278743550218231808,\"id_str\":\"1278743550218231808\",\"indices\":[241,264],\"media_url\":\"http:\\/\\/pbs.twimg.com\\/media\\/Eb8Ce92UYAA3Zri.jpg\",\"media_url_https\":\"https:\\/\\/pbs.twimg.com\\/media\\/Eb8Ce92UYAA3Zri.jpg\",\"url\":\"https:\\/\\/t.co\\/09i5vvJPrZ\",\"display_url\":\"pic.twitter.com\\/09i5vvJPrZ\",\"expanded_url\":\"https:\\/\\/twitter.com\\/eldereats\\/status\\/1278743561853440008\\/photo\\/1\",\"type\":\"photo\",\"sizes\":{\"small\":{\"w\":544,\"h\":680,\"resize\":\"fit\"},\"thumb\":{\"w\":150,\"h\":150,\"resize\":\"crop\"},\"medium\":{\"w\":960,\"h\":1200,\"resize\":\"fit\"},\"large\":{\"w\":1638,\"h\":2048,\"resize\":\"fit\"}}}]},\"source\":\"<a href=\\\"http:\\/\\/twitter.com\\/download\\/iphone\\\" rel=\\\"nofollow\\\">Twitter for iPhone<\\/a>\",\"in_reply_to_status_id\":null,\"in_reply_to_status_id_str\":null,\"in_reply_to_user_id\":null,\"in_reply_to_user_id_str\":null,\"in_reply_to_screen_name\":null,\"user\":{\"id\":757991190021144576,\"id_str\":\"757991190021144576\",\"name\":\"David Elder | KSAT 12 News\",\"screen_name\":\"eldereats\",\"location\":\"San Antonio, TX\",\"description\":\"Official twitter for KSAT 12 David Elder - Host of Texas Eats and Elder Eats - Reader’s choice best TV Personality in San Antonio 2020 by @sanantoniomag\",\"url\":\"https:\\/\\/t.co\\/eeQHP1v4i4\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"https:\\/\\/t.co\\/eeQHP1v4i4\",\"expanded_url\":\"https:\\/\\/www.ksat.com\\/texaseats\",\"display_url\":\"ksat.com\\/texaseats\",\"indices\":[0,23]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":1622,\"friends_count\":2125,\"listed_count\":17,\"created_at\":\"Tue Jul 26 17:29:17 +0000 2016\",\"favourites_count\":3346,\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":true,\"verified\":false,\"statuses_count\":1797,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"is_translation_enabled\":false,\"profile_background_color\":\"000000\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":false,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1260064508036464646\\/akKOfYh__normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1260064508036464646\\/akKOfYh__normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/757991190021144576\\/1586235536\",\"profile_link_color\":\"1B95E0\",\"profile_sidebar_border_color\":\"000000\",\"profile_sidebar_fill_color\":\"000000\",\"profile_text_color\":\"000000\",\"profile_use_background_image\":false,\"has_extended_profile\":true,\"default_profile\":false,\"default_profile_image\":false,\"following\":false,\"follow_request_sent\":false,\"notifications\":false,\"translator_type\":\"none\"},\"geo\":null,\"coordinates\":null,\"place\":{\"id\":\"07d9da3ea4081003\",\"url\":\"https:\\/\\/api.twitter.com\\/1.1\\/geo\\/id\\/07d9da3ea4081003.json\",\"place_type\":\"poi\",\"name\":\"La Panaderia\",\"full_name\":\"La Panaderia\",\"country_code\":\"US\",\"country\":\"United States\",\"contained_within\":[],\"bounding_box\":{\"type\":\"Polygon\",\"coordinates\":[[[-98.46633147146558,29.51331813629103],[-98.46633147146558,29.51331813629103],[-98.46633147146558,29.51331813629103],[-98.46633147146558,29.51331813629103]]]},\"attributes\":{}},\"contributors\":null,\"is_quote_status\":false,\"retweet_count\":4,\"favorite_count\":18,\"favorited\":false,\"retweeted\":false,\"possibly_sensitive\":false,\"possibly_sensitive_appealable\":false,\"lang\":\"en\"},\"is_quote_status\":false,\"retweet_count\":4,\"favorite_count\":0,\"favorited\":false,\"retweeted\":false,\"lang\":\"en\"}");
            Tweet actualTweet = Tweet.fromJson(jsonObject);

            // Create expected tweet
            Tweet expectedTweet = new Tweet();
            expectedTweet.body = "RT @eldereats: \uD83C\uDF53 Tres. Leches. Croissant! \uD83D\uDE2E\n" +
                    "@breadcultura - This is the tres leches croissant - a Hispanic influenced French dessert that i…";
            expectedTweet.createdAt = "Thu Jul 02 18:33:00 +0000 2020";
            expectedTweet.id = 1278758589801299968L;

            // See if they are equal
            assertEquals(actualTweet.body, expectedTweet.body);
            assertEquals(actualTweet.createdAt, expectedTweet.createdAt);
            assertEquals(actualTweet.id, expectedTweet.id);

        } catch (JSONException e) {
            Assert.fail();
        }

    }

    @Test
    public void tweetGetRelativeTimeAgo() {
        String twitterDateFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(twitterDateFormat, Locale.ENGLISH);
        Tweet testTweet = new Tweet();

        // 1 second ago
        Date oneSecondsAgo = new Date(System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(1));
        testTweet.createdAt = simpleDateFormat.format(oneSecondsAgo);
        assertEquals(testTweet.getRelativeTimeAgo(), "1s");

        // 5 seconds ago
        Date fiveSecondsAgo = new Date(System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(5));
        testTweet.createdAt = simpleDateFormat.format(fiveSecondsAgo);
        assertEquals(testTweet.getRelativeTimeAgo(), "5s");

        // 1 minute ago
        Date oneMinuteAgo = new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(1));
        testTweet.createdAt = simpleDateFormat.format(oneMinuteAgo);
        assertEquals(testTweet.getRelativeTimeAgo(), "1m");

        // 5 minutes ago
        Date fiveMinutesAgo = new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(5));
        testTweet.createdAt = simpleDateFormat.format(fiveMinutesAgo);
        assertEquals(testTweet.getRelativeTimeAgo(), "5m");

        // 1 hour ago
        Date oneHourAgo = new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1));
        testTweet.createdAt = simpleDateFormat.format(oneHourAgo);
        assertEquals(testTweet.getRelativeTimeAgo(), "1h");

        // 5 minutes ago
        Date fiveHoursAgo = new Date(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(5));
        testTweet.createdAt = simpleDateFormat.format(fiveHoursAgo);
        assertEquals(testTweet.getRelativeTimeAgo(), "5h");

    }

    // User Class
    @Test
    public void userFromJson() {
        try {
            JSONObject userJson = new JSONObject("{\"id\":735659010,\"id_str\":\"735659010\",\"name\":\"Andrew\",\"screen_name\":\"Supt_comalisd\",\"location\":\"Comal\\/Bexar\\/Guad\\/Kendall\\/Hays\",\"description\":\"\",\"url\":\"https:\\/\\/t.co\\/E1QcOEvyq0\",\"entities\":{\"url\":{\"urls\":[{\"url\":\"https:\\/\\/t.co\\/E1QcOEvyq0\",\"expanded_url\":\"http:\\/\\/www.comalisd.org\",\"display_url\":\"comalisd.org\",\"indices\":[0,23]}]},\"description\":{\"urls\":[]}},\"protected\":false,\"followers_count\":3903,\"friends_count\":147,\"listed_count\":22,\"created_at\":\"Fri Aug 03 22:39:31 +0000 2012\",\"favourites_count\":62634,\"utc_offset\":null,\"time_zone\":null,\"geo_enabled\":false,\"verified\":false,\"statuses_count\":52627,\"lang\":null,\"contributors_enabled\":false,\"is_translator\":false,\"is_translation_enabled\":false,\"profile_background_color\":\"C0DEED\",\"profile_background_image_url\":\"http:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_image_url_https\":\"https:\\/\\/abs.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"profile_background_tile\":true,\"profile_image_url\":\"http:\\/\\/pbs.twimg.com\\/profile_images\\/1161466837953064960\\/ZSz23KsL_normal.jpg\",\"profile_image_url_https\":\"https:\\/\\/pbs.twimg.com\\/profile_images\\/1161466837953064960\\/ZSz23KsL_normal.jpg\",\"profile_banner_url\":\"https:\\/\\/pbs.twimg.com\\/profile_banners\\/735659010\\/1565750248\",\"profile_link_color\":\"0084B4\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_text_color\":\"333333\",\"profile_use_background_image\":true,\"has_extended_profile\":false,\"default_profile\":false,\"default_profile_image\":false,\"following\":true,\"follow_request_sent\":false,\"notifications\":false,\"translator_type\":\"none\"}");
            User actualUser = User.fromJson(userJson);

            // Create expected user
            User expectedUser = new User();
            expectedUser.name = "Andrew";
            expectedUser.profileImageUrl = "https://pbs.twimg.com/profile_images/1161466837953064960/ZSz23KsL.jpg";
            expectedUser.screenName = "Supt_comalisd";

            // See if they are equal
            assertEquals(actualUser.name, expectedUser.name);
            assertEquals(actualUser.screenName, expectedUser.screenName);
            assertEquals(actualUser.profileImageUrl, expectedUser.profileImageUrl);

        } catch (JSONException e) {
            Assert.fail();
        }

    }


}