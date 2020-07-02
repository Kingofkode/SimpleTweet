# Project 3 - Simple Tweet

**Simple Tweet** is an android app that allows a user to view their Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: 20 hours spent in total

## User Stories

The following **required** functionality is completed:

* [x]	User can **sign in to Twitter** using OAuth login
* [x]	User can **view tweets from their home timeline**
  * [x] User is displayed the username, name, and body for each tweet
  * [x] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
* [x] User can **compose and post a new tweet**
  * [x] User can click a “Compose” icon in the Action Bar on the top right
  * [x] User can then enter a new tweet and post this to twitter
  * [x] User is taken back to home timeline with **new tweet visible** in timeline
  * [x] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
* [x] User can **see a counter with total number of characters left for tweet** on compose tweet page
* [x] User can **pull down to refresh tweets timeline**
* [x] User can **see embedded image media within a tweet** on list or detail view.

The following **stretch** features are implemented:

* [x] User is using **"Twitter branded" colors and styles**
* [ ] User sees an **indeterminate progress indicator** when any background or network task is happening
* [ ] User can **select "reply" from detail view to respond to a tweet**
  * [ ] User that wrote the original tweet is **automatically "@" replied in compose**
* [ ] User can tap a tweet to **open a detailed tweet view**
  * [ ] User can **take favorite (and unfavorite) or reweet** actions on a tweet
* [x] User can view more tweets as they scroll with infinite pagination
* [ ] Compose tweet functionality is build using modal overlay
* [ ] User can **click a link within a tweet body** on tweet details view. The click will launch the web browser with relevant page opened.
* [x] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.org/android/Using-Parceler).
* [x] Replace all icon drawables and other static image assets with [vector drawables](http://guides.codepath.org/android/Drawables#vector-drawables) where appropriate.
* [ ] User can view following / followers list through any profile they view.
* [ ] Use the View Binding library to reduce view boilerplate.
* [x] On the Twitter timeline, leverage the [CoordinatorLayout](http://guides.codepath.org/android/Handling-Scrolls-with-CoordinatorLayout#responding-to-scroll-events) to apply scrolling behavior that [hides / shows the toolbar](http://guides.codepath.org/android/Using-the-App-ToolBar#reacting-to-scroll).
* [ ] User can **open the twitter app offline and see last loaded tweets**. Persisted in SQLite tweets are refreshed on every application launch. While "live data" is displayed when app can get it from Twitter API, it is also saved for use in offline mode.

The following **additional** features are implemented:

* [x] Used higher resolution profile pictures to match the device by referencing the [Profile API](https://developer.twitter.com/en/docs/accounts-and-users/user-profile-images-and-banners)
* [x] Added circular crop to profile pictures
* [x] Added dividers between tweets
* [x] Stylized the typography of TextViews for better readability
* [x] App shows full tweets instead of summaries by referencing the [Tweet Updates API](https://developer.twitter.com/en/docs/tweets/tweet-updates)
* [x] Used floating action button from the material design library to compose tweets just like the native Twitter App 
* [x] "Tweet" button is dynamically enabled/disabled depending on if tweet is valid (more than 0 characters but less than 280)
* [x] Tap the top bar to see the latest tweets
* [x] Added Unit Tests to ensure model and method correctness

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/Kingofkode/SimpleTweet/blob/master/TwitterDemo.gif' title='Video Walkthrough' width='350' alt='Video Walkthrough' />


## Challenges while building the app

- Learning how to write unit tests for Android

- Getting the keyboard to pop up automatically when ComposeActivity launches took a lot of research, but to accomplish this it takes 2 steps:
  
  1. Set android:windowSoftInputMode="stateVisible" in a given activity of AndroidManifest.xml
  1. Call EditText.requestFocus() during onCreate() or onResume()
 

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [Parceler](https://github.com/johncarl81/parceler) - Java object Serialization when passing them between activities
- [Roboletric](https://github.com/robolectric/robolectric) - Android dependency management when writing unit tests
- [Material Components](https://github.com/material-components/material-components-android) - For floating action button in Timeline Activity

## License

    Copyright 2020 Isaiah Suarez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
