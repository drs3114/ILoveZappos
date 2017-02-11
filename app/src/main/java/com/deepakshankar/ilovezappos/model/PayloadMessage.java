package com.deepakshankar.ilovezappos.model;

import android.os.Build;

import com.google.android.gms.nearby.messages.Message;
import com.google.gson.Gson;

import java.nio.charset.Charset;

/**
 * This is the class that is used to send the payload using the nearby API.
 * @author Deepak Shankar
 */
public class PayloadMessage {
    private static final Gson gson = new Gson();

    private final String mUUID;
    private final String mMessageBody;
    private final Result payload;

    /**
     * Builds a new {@link Message} object using a unique identifier.
     */
    public static Message create(String instanceId, Result payload) {
        PayloadMessage payloadMessage = new PayloadMessage(instanceId, payload);
        return new Message(gson.toJson(payloadMessage).getBytes(Charset.forName("UTF-8")));
    }

    /**
     * Creates a {@code PayloadMessage} object from the string used to construct the payload to a
     * {@code Nearby} {@code Message}.
     */
    public static PayloadMessage receive(Message message) {
        String nearbyMessageString = new String(message.getContent()).trim();
        return gson.fromJson(
                (new String(nearbyMessageString.getBytes(Charset.forName("UTF-8")))),
                PayloadMessage.class);
    }

    /*private PayloadMessage(String uuid) {
        mUUID = uuid;
        mMessageBody = Build.MODEL;
        // TODO(developer): add other fields that must be included in the Nearby Message payload.
    }*/
    private PayloadMessage(String uuid, Result result) {
        mUUID = uuid;
        mMessageBody = Build.MODEL;
        payload = result;
        // TODO(developer): add other fields that must be included in the Nearby Message payload.
    }

    public String getMessageBody() {
        return mMessageBody;
    }

    public Result getPayload(){
        return payload;
    }
}