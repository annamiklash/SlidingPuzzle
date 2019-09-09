package mi.mi.miklash.slidingpuzzle.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;

@Getter
public class Node extends ImageView {

    private int nodeNumber;
    private boolean isSelected;

    public Node(Image image, int nodeNumber) {
        super(image);
        this.nodeNumber = nodeNumber;

        initNode();
    }

    private void initNode() {
        this.setFitWidth(100);
        this.setFitHeight(100);
    }

    public boolean isSelected() {
        return isSelected;
    }


    public void setSelected() {
        isSelected = true;

    }

    public void setNotSelected() { //show sleeve
        isSelected = false;
    }


    public void switchNodes(Node that) {
//
//        int temp = 0;
//
//        temp = this.nodeNumber;
//        this.nodeNumber = that.nodeNumber;
//        that.nodeNumber = temp;
//
//
//        Image thisImage = this.getImage();
//        Image tempImage = null;
//        Image thatImage = that.getImage();
//
//        tempImage = thisImage;
//        thisImage = thatImage;
//        thatImage = tempImage;


    }
}

