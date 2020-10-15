import android.os.AsyncTask;

public class BackgroundTask extends AsyncTask<String, Void, String>{
   @Override
   Contect ctx;

   BackgroundTask(Context ctx){
       this.ctx = ctx;
   }
   protected String doInBackground(String... params){
       String reg_url="http://localhost/project/register.php";
       String method = params[0];
       if(method.equals("register")){
        String name=params[1];
        String password=params[2];
        String contact=params[3];
        String country=params[4];
       
       try{
        URL url = new URL(reg_url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        OutputStream os = httpURLConnection.getOutputStream();

        BufferWriter bufferWriter = new BufferWriter(new OutputStreamWriter(os,"UTF-8"));
        String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                      URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                      URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"+
                      URLEncoder.encode("country","UTF-8")+"="+URLEncoder.encode(country,"UTF-8");
        bufferWriter.write(data);
        bufferWriter.flush();
        bufferWriter.close();
        os.close();
        InputStream IS = httpURLConnection.getInputStream();
        IS.close();
        return "Registration successfull";
        }catch(MalFormedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
       }

     return null;
   }

    @Override
   protected void onPostExecute(String result){
       //super.onPostExecute(result);
       Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
   }

     @Override
   protected void onPreExecute(){
       super.onPreExecute();
   }
     @Override
   protected void onProgressUpdate(Void... values){
       super.onProgressUpdate(values);
   }
}