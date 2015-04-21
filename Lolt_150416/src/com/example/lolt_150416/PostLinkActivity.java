package com.example.lolt_150416;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.XmlDom;

public class PostLinkActivity extends Activity{// ActionBarActivity {

    EditText address1;
    EditText address2;
    ListView list;
    Button search;
    CustomAdapter adapter;
    ArrayList<DetailList> data = new ArrayList<DetailList>();
    AQuery mAq;

    DetailListResponse response = new DetailListResponse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_link);
        address1 = (EditText)findViewById(R.id.address1);
        address2 = (EditText)findViewById(R.id.address2);
        list = (ListView)findViewById(R.id.addresslist);
        search = (Button)findViewById(R.id.search);
        adapter = new CustomAdapter(data, this.getBaseContext());

        list.setAdapter(adapter);
        mAq = new AQuery(this);

        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //url 생성
                String urlformat = "http://openapi.epost.go.kr/postal/retrieveLotNumberAdressService/retrieveLotNumberAdressService/getDetailList" +
                        "?searchSe=dong" +
                        "&srchwrd=%s" +
                        "&serviceKey=Zfp7YfCVnVGZIL4eBd90G963gy/AnUGe0W86Z/YLukYBcQ7xHdyuMlaCsS4/1bCpiWrA0ZBN953XnhZvXfUmnQ==";

                String url = String.format(urlformat, address1.getText().toString());

                mAq.ajax(url, XmlDom.class, new AjaxCallback<XmlDom>(){

                    @Override
                    public void callback(String url, XmlDom object, AjaxStatus status) {
                        List<XmlDom> items = object.tags("detailList");

                        CmmMsgHeader cmmMsgHeader = new CmmMsgHeader();

                        cmmMsgHeader.setErrMsg( object.tag("cmmMsgHeader").tag("errMsg").text());
                        cmmMsgHeader.setSuccessYN( object.tag("cmmMsgHeader").tag("successYN").text());
                        cmmMsgHeader.setReturnCode( object.tag("cmmMsgHeader").tag("returnCode").text());

                        data.clear();

                        for(int i=0; i<items.size(); ++i) {
                            XmlDom item = items.get(i); //Node가 리턴

                            DetailList detailItem = new DetailList();
                            detailItem.setAdres(item.tag("adres").text());
                            detailItem.setZipNo(item.tag("zipNo").text());
                            detailItem.setNo(Integer.parseInt(item.tag("no").text()));

                            data.add(detailItem);
                            //끝
                        }

                        response.setDetailList(data);
                        response.setCmmMsgHeader(cmmMsgHeader);

                        //데이터 연결

                        //화면갱신
                        adapter.notifyDataSetChanged();
                    }

                });
            }
        });
    }
    /////////////////////////
    class CustomAdapter extends BaseAdapter{
        ArrayList list;
        Context context;

        public CustomAdapter(ArrayList list, Context context){
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public DetailList getItem(int position) {
            return (DetailList)list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //Adapter의 진짜 역할!!
        //ListView에 데이터 출력
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.post_link_item_listview, null);
            }else{
                //convertView는 꽉차있음
            }
            TextView tv = (TextView)convertView.findViewById(R.id.item_textview);

            tv.setText(getItem(position).getZipNo() + "\n" + getItem(position).getAdres());

            tv.setTag(getItem(position));
            tv.setOnClickListener(listener);

            return convertView;
        }

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DetailList list = (DetailList)v.getTag();
                Toast.makeText(context, list.getZipNo() + "\n" + list.getAdres() , Toast.LENGTH_SHORT).show();;
            }
        };
    }
}

//@Root
class DetailList{
    //  @Element(required = false)
    int no;
    //  @Element(required = false)
    String zipNo;
    // @Element(required = false)
    String adres;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getZipNo() {
        return zipNo;
    }

    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}

//@Root
class CmmMsgHeader {
    //  @Element(required = false)
    String requestMsgId;
    //  @Element(required = false)
    String responseMsgId;
    // @Element(required = false)
    String responseTime;
    // @Element(required = false)
    String successYN;
    // @Element(required = false)
    String returnCode;
    // @Element(required = false)
    String errMsg;

    public String getRequestMsgId() {
        return requestMsgId;
    }

    public void setRequestMsgId(String requestMsgId) {
        this.requestMsgId = requestMsgId;
    }

    public String getResponseMsgId() {
        return responseMsgId;
    }

    public void setResponseMsgId(String responseMsgId) {
        this.responseMsgId = responseMsgId;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getSuccessYN() {
        return successYN;
    }

    public void setSuccessYN(String successYN) {
        this.successYN = successYN;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}

//@Root(name="DetailListResponse")
class DetailListResponse{
    //  @Element
    CmmMsgHeader cmmMsgHeader;
    //  @ElementList(required = false)
    List<DetailList> detailList;

    public CmmMsgHeader getCmmMsgHeader() {
        return cmmMsgHeader;
    }

    public void setCmmMsgHeader(CmmMsgHeader cmmMsgHeader) {
        this.cmmMsgHeader = cmmMsgHeader;
    }

    public List<DetailList> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<DetailList> detailList) {
        this.detailList = detailList;
    }
}

