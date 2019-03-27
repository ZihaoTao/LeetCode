public class candy {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = 1;
        }

        for(int i = 0; i < res.length - 1; i++) {
            if(ratings[i + 1] > ratings[i]) {
                res[i + 1] = res[i] + 1;
            }
        }

        for(int i = res.length - 1; i >= 1; i--) {
            if(ratings[i - 1] > ratings[i]) {
                res[i - 1] = Math.max(res[i - 1], res[i] + 1);
            }
        }

        int sum = 0;
        for(int i : res) {
            sum += i;
        }

        return sum;
    }

    public int count(int n) {
        return (n * (n + 1)) / 2;
    }


    public int candy2(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
                up++;
            if (new_slope < 0)
                down++;
            if (new_slope == 0)
                candies++;

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }



}
