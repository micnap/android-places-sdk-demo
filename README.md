This repo contains the app created during a webinar for Udacity's Android Developer Nanodegree. See https://youtu.be/YqIFoNCzVk0 for the video. It gives an overview of how to use Google's Places SDK for Android, demonstrating the use of the AutocompleteSupportFragment and AutocompleteActivity widgets.

It contains 3 activities with accompanying layouts:

MainActivity:
Allows the user to choose between trying out the AutocompleteSupportFragment widget and the AutocompleteActivity widget.
[[https://github.com/micnap/android-places-sdk-demo/blob/master/repoImages/MainActivity.png|alt=Main]]

AutocompleteFragmentActivity:
Implements the AutocompleteSupportFragment. Enter text in the search field and a list of results will be displayed below it.  Choose an item from the list and the details will be displayed.

AutocompleteActivityActivity:
Implements the AutocompleteActivity. Enter text in the search field and a list of results will be displayed below it.  Choose an item from the list and the details will be displayed.

Usage:
- Clone the repo and import it into Android Studio.
- Create an API in the Google Cloud Platform according to the accompanying video (https://youtu.be/YqIFoNCzVk0).
- Create a file called key.txt in the assets folder.  Paste the key into the file.
- Run the app.