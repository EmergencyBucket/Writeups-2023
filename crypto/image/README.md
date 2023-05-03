# Image - Hard
**Author:** [Mrxbox98#1482](https://github.com/mrxbox98)
## Running
```bash
docker build -t image_hard .
docker run -p 5000:80 image_hard
```
> Open https://localhost:5000 in a browser

## Solution
The first step is the read the stream of bytes at the zero path to find the current random bytes. Next predict the random bytes and place them in the proper format that the jarfile would generate. Once you go to the path you get the flag ``bucket{x0r_15_n0t_s4f3_10a87a0b3}``.