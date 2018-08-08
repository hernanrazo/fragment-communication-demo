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


Sources and Helpful Links
---

https://developer.android.com/training/basics/fragments/communicating  
https://www.youtube.com/watch?v=i22INe14JUc  



