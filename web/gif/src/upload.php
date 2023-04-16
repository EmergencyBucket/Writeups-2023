<html>
    <body>
        <h3>File Upload Stats: </h3>
        <?php
            if($_FILES["file"]["error"])
            {
                header("Location: file.html");
                die();
            }

            
            $imageDetails = getimagesize($_FILES["file"]["tmp_name"]);
            if($imageDetails == FALSE || mime_content_type($_FILES["file"]["tmp_name"]) != "image/gif")
            {
                echo "Please upload a GIF file";
            }
            else
            {
                move_uploaded_file($_FILES["file"]["tmp_name"], "uploads/".$_POST["name"]);
                print ("File has been uploaded!");
            }
        ?>
    </body>
</html>