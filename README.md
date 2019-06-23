This repo contains the app created during a webinar for Udacity's Android Developer Nanodegree. See https://youtu.be/YqIFoNCzVk0 for the video. It gives an overview of how to use Google's Places SDK for Android, demonstrating the use of the AutocompleteSupportFragment and AutocompleteActivity widgets.

It contains 3 activities with accompanying layouts:

MainActivity:
Allows the user to choose between trying out the AutocompleteSupportFragment widget and the AutocompleteActivity widget.<br><br>
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/MainActivity.png" width="250px"><br><br>

AutocompleteFragmentActivity:
Implements the AutocompleteSupportFragment. Enter text in the search field and a list of results will be displayed below it.  Choose an item from the list and the details will be displayed.<br><br>
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/fragment.png" width="250px"> 
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/fragment_search.png" width="250px">
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/fragment_result.png" width="250px">
<br><br>

AutocompleteActivityActivity:
Implements the AutocompleteActivity. Enter text in the search field and a list of results will be displayed below it.  Choose an item from the list and the details will be displayed.<br><br>
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/activity.png" width="250px">
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/activity_search.png" width="250px">
<img src="https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/activity_result.png" width="250px">
<br><br>

Usage:
- Clone the repo and import it into Android Studio.
- Create an API in the Google Cloud Platform according to the accompanying video (https://youtu.be/YqIFoNCzVk0).
- Create a file called key.txt in the assets folder.  Paste the key into the file.
- Run the app.
