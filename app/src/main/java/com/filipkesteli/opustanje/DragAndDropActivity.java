package com.filipkesteli.opustanje;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DragAndDropActivity extends AppCompatActivity {

    private Button btnDrag;
    private LinearLayout llDrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnDrag = (Button) findViewById(R.id.btnDrag);
        llDrop = (LinearLayout) findViewById(R.id.llDrop);
    }

    private void setupListeners() {
        btnDrag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //proizvoljni podaci:
                ClipData clipData = ClipData.newPlainText("","");
                //pretvarac widgeta u draggable objekt:
                View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(btnDrag);
                //pocetak dragganja:
                v.startDrag(clipData, dragShadowBuilder, null, 0);
                //po defaultu se vraca false:
                return false;
            }
        });
        llDrop.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Toast.makeText(DragAndDropActivity.this, "Pocinjemo s dragganjem", Toast.LENGTH_SHORT).show();
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DROP:
                        Toast.makeText(DragAndDropActivity.this, "Droppano", Toast.LENGTH_SHORT).show();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}
