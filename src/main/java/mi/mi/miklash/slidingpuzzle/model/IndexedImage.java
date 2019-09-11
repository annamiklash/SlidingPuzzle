package mi.mi.miklash.slidingpuzzle.model;

import javafx.scene.image.Image;
import lombok.Getter;


@Getter
public class IndexedImage extends Image {

    private final int index;

    public IndexedImage(String url, int index) {
        super(url);
        this.index = index;
    }


}
