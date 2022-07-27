package com.nk.richedittexttemp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jp.wasabeef.richeditor.RichEditor;

/*
Template mady by using https://github.com/wasabeef/richeditor-android
 */

public class RichTextOneActivity extends AppCompatActivity {

    private RichEditor richEditText;
    private TextView textView, richTextView;
    private ImageView undoBtnImageView, redoBtnImageView, boldBtnImageView, italicBtnImageView,
            underlinedBtnImageView, colorTextBtnImageView, bgColorTextBtnImageView,
            indentDecreaseTextBtnImageView, indentIncreaseTextBtnImageView, alignLeftTextBtnImageView,
            alignCenterTextBtnImageView, alignRightTextBtnImageView, listBulletedBtnImageView,
            list_numbers_btn_image_view;
    private boolean isChanged, isBgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rich_text_one);

        getSupportActionBar().setTitle("Rich Edit Text Wasabeef");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setReferences();

//        richEditText.setEditorHeight(200);
//        richEditText.setEditorFontSize(22);
//        richEditText.setEditorFontColor(getColor(R.color.pink));

        richEditText.setBackgroundColor(getColor(R.color.light_blue_input_not_transparent));
//        richEditText.setBackgroundResource(R.drawable.rich_edit_text_style); //not working. Error set to null object
        richEditText.setPadding(16, 16, 16, 16);
        richEditText.setPlaceholder("Insert text here...");



        richEditText.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            @Override
            public void onTextChange(String text) {
                textView.setText(text);
                richTextView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
            }
        });

        undoBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.undo();
            }
        });

        redoBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.redo();
            }
        });

        boldBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setBold();
            }
        });

        italicBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setItalic();
            }
        });

        underlinedBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setUnderline();
            }
        });

        colorTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setTextColor(isChanged ? Color.BLACK: Color.RED);
                isChanged = !isChanged;
            }
        });

        bgColorTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setTextBackgroundColor(isBgColor ? Color.TRANSPARENT: Color.YELLOW);
                isBgColor = !isBgColor;
            }
        });

        indentDecreaseTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setIndent();
            }
        });

        indentIncreaseTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setOutdent();
            }
        });

        alignLeftTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setAlignLeft();
            }
        });

        alignCenterTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setAlignCenter();
            }
        });

        alignRightTextBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setAlignRight();
            }
        });

        listBulletedBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setBullets();
            }
        });

        list_numbers_btn_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                richEditText.setNumbers();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setReferences(){
        richEditText = findViewById(R.id.rich_edit_text);
        textView = findViewById(R.id.text_view);
        richTextView = findViewById(R.id.rich_text_view);
        undoBtnImageView = findViewById(R.id.undo_btn_image_view);
        redoBtnImageView = findViewById(R.id.redo_btn_image_view);
        boldBtnImageView = findViewById(R.id.bold_btn_image_view);
        italicBtnImageView = findViewById(R.id.italic_btn_image_view);
        underlinedBtnImageView = findViewById(R.id.underlined_btn_image_view);
        colorTextBtnImageView = findViewById(R.id.color_text_btn_image_view);
        bgColorTextBtnImageView = findViewById(R.id.bg_color_text_btn_image_view);
        indentDecreaseTextBtnImageView = findViewById(R.id.indent_decrease_text_btn_image_view);
        indentIncreaseTextBtnImageView = findViewById(R.id.indent_increase_text_btn_image_view);
        alignLeftTextBtnImageView = findViewById(R.id.align_left_text_btn_image_view);
        alignCenterTextBtnImageView = findViewById(R.id.align_center_text_btn_image_view);
        alignRightTextBtnImageView = findViewById(R.id.align_right_text_btn_image_view);
        listBulletedBtnImageView = findViewById(R.id.list_bulleted_btn_image_view);
        list_numbers_btn_image_view = findViewById(R.id.list_numbers_btn_image_view);
    }
}