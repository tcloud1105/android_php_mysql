package com.example.application.demodatabase;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        String json_builder;
        String JSON_STRING;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        
    }

    public void getjson(View view){
      new BackgroundTask().execute();
    }

    public void parsejson(View view){
        Intent intent = new Intent(this, DisplayListView.class);
        intent.putExtra("json_data", JSON_STRING);
        startActivity(intent);
    }

    public class BackgroundTask extends AsyncTask<Void, Void, String>{

        String json_url="http://localhost/project/getjson.php";
        protected String doInBackground(Void... params){
        try{
        URL url = new URL(reg_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        InputStream inputStream = httpURLConnection.getInputStream();
        BufferReader bufferReader = new BufferReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        
        while((json_string=bufferReader.readLine())!=null){
            stringBuilder.append(json_string+"\n");
        }
        bufferReader.close();
        inputStream.close();
        httpURLConnection.disconnect();
        return stringBuilder.toString().trim();
        }catch(MalFormedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
       }

     return null;
   }

   public BackgroundTask(){
       super();
   }

   @Override
   protected void onPostExecute(String result){
     TextView textview = (TextView)findViewById(R.id.textview);
     textview.setText(result);
      JSON_STRING=result;
   }
    }
}