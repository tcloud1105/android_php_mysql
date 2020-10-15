
public class ContactAdapter extends ArrayAdapter{

   List list = new ArrayList();
    public ContactAdapter(Context context, int resource){
        super(context, resource);
    }

    @Override
    public void add(Contacts object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent, false);
            contactHolder.tx_name = (TextView)row.findViewById(R.id.tx_name);
            contactHolder.tx_email = (TextView)row.findViewById(R.id.tx_email);
            contactHolder.tx_contact = (TextView)row.findViewById(R.id.tx_contact);
            contactHolder.tx_password= (TextView)row.findViewById(R.id.tx_password);
            row.setTag(contactHolder);
        }else{
            contactHolder = (ContactHolder)row.getTag();
        }

        Contacts contacts = (Contacts)this.getItem(position);
        contactHolder.tx_name.setText(contacts.getName());
        contactHolder.tx_email.setText(contacts.getEmail());
        contactHolder.tx_contact.setText(contacts.getContact());
        contactHolder.tx_password.setText(contacts.getPassword());

        return row;
    }

    static class ContactHolder{
        TextView tx_name, tx_email, tx_contact, tx_password;
    }
}