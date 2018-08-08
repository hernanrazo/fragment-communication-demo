Fragment Communication Demo
===

An Android app that showcases fragment communication. This specific example uses two fragments. To do this, the user is asked to type letters into the editText prompt in either fragment. Pressing the send buton tells the fragments to communicate and update the characters typed into both fragments. 

Explanation
---

Fragments communicate to one another using interfaces and the associated activity. In this case, `MainActivity.java` is the activity used for communiation. You can see the `fragmentOne.java` that the interface is named `fragmentOneListener`:  

```java
    public interface fragmentOneListener {
        void onInputOneSent(CharSequence input);
    }
```  

This interface is then used in the `setOnClickListener()` for the send button:

```java
CharSequence input = editTextOne.getText();
                listener.onInputOneSent(input);
```   
This same mechanism is used in `fragmentTwo.java` where the interface is named `fragmentTwoListener`.

Both fragments also use the `updateText` method to carry the string information between fragments. 

The same intefaces allow cross fragment communication by beign used in `MainActivity.java`: 

```java
@Override
    public void onInputOneSent(CharSequence input) {
        fragmentTwo.updateText(input);
    }

    @Override
    public void onInputTwoSent(CharSequence input) {
        fragmentOne.updateText(input);
    }
```  

Demo
---
The app opens up with `fragmentOne` on top in light blue and `fragemntTwo` on the bottom in dark blue. 
<img src="https://github.com/hrazo7/fragment-communication-demo/blob/master/screenshots/mainScreen.png" width="400" height="650" title="Main Screen"> 

When the user taps on the editText area, the keyboard will pop up and allow the user to type. This screenshot shows the user typing onto `fragmentOne`.

<img src="https://github.com/hrazo7/fragment-communication-demo/blob/master/screenshots/fragmentOneInput.png" width="400" height="650" title="fragmentOneInput"> 

Upon pressing send, the editText field in `fragemntTwo` should have the exact same string as in `fragemntOne`.

<img src="https://github.com/hrazo7/fragment-communication-demo/blob/master/screenshots/fragmentOneSend.png" width="400" height="650" title="fragmentOneSend">

Now, you can edit the string in `fragemntTwo` by doing the same thing but in the `fragemntTwo` editText field. Start typing new characters.

<img src="https://github.com/hrazo7/fragment-communication-demo/blob/master/screenshots/fragmentTwoInput.png" width="400" height="650" title="fragmentTwoInput">

Press send again to submit the changes onto `fragemntOne`.

<img src="https://github.com/hrazo7/fragment-communication-demo/blob/master/screenshots/fragmentTwoSend.png" width="400" height="650" title="fragmentTwoSend">

Sources and Helpful Links
---

https://developer.android.com/training/basics/fragments/communicating  
https://www.youtube.com/watch?v=i22INe14JUc  



