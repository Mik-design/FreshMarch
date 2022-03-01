package kg.tutorial.freshmarch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button? = findViewById(R.id.btn)


        button?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            // start your next activity
            startActivity(intent)
        }



        // Instance of users list using the data model class.
        val usersList: ArrayList<UserModelClass> = ArrayList()

        try {
            // As we have JSON object, so we are getting the object
            //Here we are calling a Method which is returning the JSON object
            val obj = JSONObject(getJSONFromAssets())
            // fetch JSONArray named users by using getJSONArray
            val usersArray = obj.getJSONArray("company")
            // Get the users data using for loop i.e. id, name, email and so on

            for (i in 0 until usersArray.length()) {
                // Create a JSONObject for fetching single User's Data
                val company = usersArray.getJSONObject(i)
                // Fetch id store it in variable

               /* val firstname = user.getString("first_name")
                val photo = user.getString("photo")
                val secondname = user.getString("second_name")
                val education = user.getInt("education")*/

                val name = company.getString("name")
                // fetch position
                val position = company.getString("position")


                // create a object for getting name & position data from JSONObject

                /*val company = user.getJSONObject("company")
                // fetch name
                val name = company.getString("name")
                // fetch position
                val position = company.getString("position")*/

                val user = company.getJSONObject("user")
                 val firstname = user.getString("first_name")
                val photo = user.getString("photo")
                val secondname = user.getString("second_name")
                val education = user.getInt("education")

                // Now add all the variables to the data model class and the data model class to the array list.
                val userDetails =
                    UserModelClass(firstname, photo, secondname, education, name, position)

                // add the details in the list
                usersList.add(userDetails)
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        // Set the LayoutManager that this RecyclerView will use.

        val rvUsersList = findViewById<RecyclerView>(R.id.rvUsersList)
        val linearLayoutManager = LinearLayoutManager(applicationContext)

        rvUsersList.layoutManager = linearLayoutManager
        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = UserAdapter(this, usersList)
        // adapter instance is set to the recyclerview to inflate the items.
        rvUsersList.adapter = itemAdapter

    }

    /**
     * Method to load the JSON from the Assets file and return the object
     */
    private fun getJSONFromAssets(): String {

        val json: String
        val charset: Charset = Charsets.UTF_8
        try {
            val myUserJSONFile = assets.open("User.json")
            val size = myUserJSONFile.available()
            val buffer = ByteArray(size)
            myUserJSONFile.read(buffer)
            myUserJSONFile.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}



