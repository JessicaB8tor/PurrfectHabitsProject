package persistence;

import org.json.JSONObject;

// Note: this class was based entirely on the Writable class
//       found in the WorkRoom application given to us on GitHub.
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
