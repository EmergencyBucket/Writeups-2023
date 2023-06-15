# Random-Security - Medium
**Author:** [Mrxbox98#1482](https://github.com/mrxbox98)
## Running
```bash
docker build -t maze .
docker run -p 5000:80 maze
```
> Run nc 0.0.0.0 5000

## Solution
The solution is to predit the previous ``Math.random()`` calls using the random values you can get now.

After decompiling the file you can calculate the how many calls there are to random.

Use the following method to reverse engineer the random values.

Source: https://stackoverflow.com/questions/32324404/can-you-find-previously-generated-random-numbers-using-java-util-random
```java
public class InvRand {
    private static final long addend = 0xBL;
    private static final long multiplier = 0x5DEECE66DL;
    private static final long invMultiplier = 0xDFE05BCB1365L;
    private static final long mask = 0xFFFFFFFFFFFFL;

    private long seed;

    public InvRand(Random r) {
        seed = prevSeed(replicateSeed(r.nextLong()));
    }

    public long prevLong() {
        seed = prevSeed(seed);
        long b1 = seed >>> 16;
        seed = prevSeed(seed);
        long b2 = seed >>> 16;
        return (b2 << 32) + b1;
    }

    static long replicateSeed(long nextLong) {
        int nextM = (int)(nextLong & 0xFFFFFFFF);
        int nextN = (int)((nextLong - nextM) >> 32);

        long upperMOf48Mask = 0xFFFFFFFF0000L;

        long oldSeedUpperN = ((long)nextN << 16) & mask;
        long newSeedUpperM = ((long)nextM << 16) & mask;

        for (long oldSeed = oldSeedUpperN; oldSeed <= (oldSeedUpperN | 0xFFFF); 
                  oldSeed++) {
            long newSeed = (oldSeed * multiplier + addend) & mask;
            if ((newSeed & upperMOf48Mask) == newSeedUpperM) {
                return newSeed;
            }
        }
        throw new InternalError();
    }

    static long prevSeed(long seed) {
        return ((seed - addend) * invMultiplier) & mask;
    }
}
```

Flag: ``bucket{r4nd0m_n3v3r_w0rk5_e92fc72d}``