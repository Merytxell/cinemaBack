package fr.fms.Cinema.web;

import fr.fms.Cinema.Entities.Movie;
import fr.fms.Cinema.service.ImplBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ImageController {


    private final ImplBusinessService implBusinessService;

    @Autowired
    public ImageController (ImplBusinessService implBusinessService){
        this.implBusinessService=implBusinessService;
    }

    @GetMapping(path = "image/{id}")
    public ResponseEntity<?>getImage (@PathVariable("id") Long id) throws IOException
    {
        byte [] file = null;
        try
        {
            Movie movie = implBusinessService.readMovie(id).get();
            if (movie.getImageName() == null)
            {
               movie.setImageName("default.png");
            }
            File imgFile = new File(System.getProperty("user.home") + "/Pictures/cinema/" + movie.getImageName());
            BufferedImage image = ImageIO.read(imgFile);
            int minWidth = 100;
            int minHeight = 100;
            int maxWidth = 200;
            int maxHeight = 200;
            int width = image.getWidth();
            int height = image.getHeight();

            if (width > maxWidth || height > maxHeight || width < minWidth || height < minHeight) {
                float aspectRatio = (float) width / height;
                if (aspectRatio > 1) {
                    width = maxWidth;
                    height = (int) (maxWidth / aspectRatio);
                } else {
                    height = maxHeight;
                    width = (int) (maxHeight * aspectRatio);
                }

                BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resizedImage.createGraphics();
                g.drawImage(image, 0, 0, width, height, null);
                g.dispose();


                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(resizedImage, "png", baos);
                file = baos.toByteArray();

            } else {

                file = Files.readAllBytes(imgFile.toPath());
            }
        }
        catch (Exception e)
        {
            System.out.println("erreur image");
        }
        return ResponseEntity.ok().body(file);
    }


    @PostMapping(path = "/image/{id}")
    public ResponseEntity<?> uploadPhoto ( MultipartFile file , @PathVariable Long id ) throws Exception
    {
        try
        {
            Movie movie = implBusinessService.readMovie(id).get();
            movie.setImageName(file.getOriginalFilename());
            Files.write(Paths.get(System.getProperty("user.home") + "/Pictures/trainings/" + movie.getImageName()), file.getBytes());
            implBusinessService.saveMovie(movie);
        }
        catch (Exception e)
        {
            System.out.println("error upload photo");
        }
        return ResponseEntity.ok().build();    }
}


