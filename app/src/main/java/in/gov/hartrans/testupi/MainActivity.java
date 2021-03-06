package in.gov.hartrans.testupi;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.hdfcmerchant.PayActivity;
import com.hdfcmerchant.Registration;
import com.hdfcmerchant.SetMpin;

public class MainActivity extends AppCompatActivity {

    private TextView outputView;
    private AppCompatButton bt_testUPI;
    private AppCompatButton bt_registrationUPI;
    private AppCompatButton bt_generateMPIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputView = (TextView) findViewById(R.id.outputView);
        bt_testUPI = (AppCompatButton) findViewById(R.id.bt_testUPI);
        bt_registrationUPI = (AppCompatButton) findViewById(R.id.bt_registrationUPI);
        bt_generateMPIN = (AppCompatButton) findViewById(R.id.bt_generateMPIN);


        bt_testUPI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                upi_transaction();
            }
        });
    }

    private void upi_transaction(){
        Bundle bundle = new Bundle();
        bundle.putString("mid", "HDFC000000000044");
        bundle.putString("merchantKey", "7c448fb4c6eb425e86f8817ae5488533");
        bundle.putString("merchantTxnID", "123456789141");
        bundle.putString("transactionDesc", "pnr123456141");
        bundle.putString("currency", "INR");
        bundle.putString("appName", "in.gov.hartrans.testupi");
        bundle.putString("paymentType", "P2M");
        bundle.putString("transactionType", "COLLECT");
        bundle.putString("payeePayAddress", "");
        bundle.putString("payeeAccntNo", "");
        bundle.putString("payeeIFSC", "");
        bundle.putString("payeeAadhaarNo", "");
        bundle.putString("payeeMobileNo", "");
        bundle.putString("merchantCatCode", "");
        bundle.putString("expiryTime", "");
        bundle.putString("payerAccntNo", "");
        bundle.putString("payerIFSC", "");
        bundle.putString("payerAadhaarNo", "");
        bundle.putString("payerMobileNo", "");
        bundle.putString("payerPaymentAddress", "");
        bundle.putString("subMerchantID", "");
        bundle.putString("whitelistedAccnts", "");
        bundle.putString("payerMMID", "");
        bundle.putString("payeeMMID", "");
        bundle.putString("refurl", "");
        bundle.putString("amount","140.00");
        bundle.putString("add1", "");
        bundle.putString("add2", "");
        bundle.putString("add3", "");
        bundle.putString("add4", "");
        bundle.putString("add5", "");
        bundle.putString("add6", "");
        bundle.putString("add7", "");
        bundle.putString("add8", "");
        bundle.putString("add9", "");
        bundle.putString("add10", "");

        Intent intent = new Intent(getApplicationContext(), PayActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        try{
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null)
            {
                Bundle bundle = data.getExtras();
            String pgMeTrnRefNo = bundle.getString("pgMeTrnRefNo");
            String orderNo = bundle.getString("orderNo");
            String txnAmount = bundle.getString("txnAmount");
            String tranAuthdate = bundle.getString("tranAuthdate");
            String approvalCode = bundle.getString("approvalCode");
            String payerVA = bundle.getString("payerVA");
            String npciTxnId = bundle.getString("npciTxnId");
            String refId = bundle.getString("refId");
            String add1 = bundle.getString("add1");
            String add2 = bundle.getString("add2");
            String add3 = bundle.getString("add3");
            String add4 = bundle.getString("add4");
            String add5 = bundle.getString("add5");
            String add6 = bundle.getString("add6");
            String add7 = bundle.getString("add7");
            String add8 = bundle.getString("add8");
            String add9 = bundle.getString("add9");
            String add10 = bundle.getString("add10");
            String statusCode = bundle.getString("status");
            String statusDesc = bundle.getString("statusDesc");
            String responsecode = bundle.getString("responsecode");

                String responsE;
                responsE="States Code: "  +statusCode + "<br/>";
                responsE+="States Desc: "  +statusDesc + "<br/>";
                responsE+="responsecode: "  +responsecode + "<br/>";
                responsE+="pgMeTrnRefNo: "  +pgMeTrnRefNo + "<br/>";
                responsE+="orderNo: "  +orderNo + "<br/>";
                responsE+="txnAmount: "  +txnAmount + "<br/>";
                responsE+="tranAuthdate: "  +tranAuthdate + "<br/>";
                responsE+="approvalCode: "  +approvalCode + "<br/>";
                responsE+="payerVA: "  +payerVA + "<br/>";
                responsE+="npciTxnId: "  +npciTxnId + "<br/>";
                responsE+="refId: "  +refId + "<br/>";

                outputView.setText(Html.fromHtml(responsE));

            }}catch (Exception ex) {
            outputView.setText(ex.getMessage());
        }
    }
}
