# Gif - Hard
**Author:** [Mrxbox98#1482](https://github.com/mrxbox98)
## Running
```bash
docker build -t gif_hard .
docker run -p 5000:80 gif_hard
```
> Open https://localhost:5000 in a browser

## Solution
The source code uses ``getimagesize`` and ``mime_content_type`` to validate whether the file is a gif or not. The user provided file name is never validated so it is possible to save a file with the ``.php`` extension.  

The first step is to create a file which will return a valid size when ``getimagesize`` is called. To do this, we use [Gifsicle](https://www.lcdf.org/gifsicle/) to add php code into a gif image as a comment. Do this by running
```bash
apt install gifsicle
gifsicle -comment "`tr '\n' ' ' < your_backdoor.php`" < your_gif.gif > backdoored_gif.gif
```
Once you have your new gif go to the website and upload the file with the name being ``backdoor.php``. Once finished uploading, head to ``/uploads/backdoor.php`` and use the backdoor to read out the file ``flag.txt`` in the ``/`` directory.

Flag: ``bucket{1_h4t3_PHP}``