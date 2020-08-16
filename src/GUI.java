import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;


public class GUI  extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane page =  getFullPage();

        Scene scene = new Scene(page, 900, 700);
        String fontSheet = fileToStylesheetString( new File ("resources/main.css") );

        if ( fontSheet == null ) {
            System.out.println("uhoh spaghettios");         //hopefully we don't get here
        } else {
            scene.getStylesheets().add( fontSheet );
        }


        stage.setScene(scene);
        stage.setTitle("OpenRecipes v1.0.0");
        stage.show();

    }

    //Weird thing I found on StackOverflow - only way I could get my external css sheet to load
    private String fileToStylesheetString ( File stylesheetFile ) {
        try {
            return stylesheetFile.toURI().toURL().toString();   //parse the file to a URL and back to a string to force out spaces? I think?
        } catch ( MalformedURLException e ) {
            return null;
        }
    }

    private BorderPane getFullPage(){
        BorderPane page = new BorderPane();

        page.setLeft(nav(page));

        return page;
    }
    private Pane nav(BorderPane page) {
        Pane nav = new Pane();


        Button postButton = getNavButton("Post a new recipe");
        Button browseButton = getNavButton("Browse recipes");
        Button listButton = getNavButton("Shopping list");

        page.setCenter(browsePane());


        VBox navItems = new VBox(browseButton, postButton, listButton);
        navItems.setPrefHeight(500);
        nav.setPrefHeight(500);
        navItems.setSpacing(15);
        navItems.setId("nav-pane");
        nav.setId("nav-pane");
        navItems.setPrefWidth(250);

        navItems.setSpacing(1);
        navItems.setPadding(new Insets(0));

        nav.getChildren().add(navItems);
        nav.setPrefWidth(250);

        return nav;
    }

    private Button getNavButton(String text){
        Button btn = new Button(text);
        btn.setPrefWidth(250);
        btn.setPrefHeight(50);
        btn.setId("nav-button");
        btn.setPadding(new Insets(0));

        return btn;
    }

    private Pane postPane(Post post){
        Pane pPane = new Pane();
        Text title = new Text(post.getTitle());

        return pPane;
    }

    private Pane browsePane(){
        Pane bPane = new Pane();
        return bPane;
    }

    public static void main(String[] args){
        launch(args);
    }
}
