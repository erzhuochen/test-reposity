package com.itheima;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;
import static java.lang.Math.abs;
import static java.lang.Math.min;


public class Solution {

    @Test
    public void read() throws FileNotFoundException {

        URL resource = Solution.class.getResource("in.txt");
        String pathFile = resource.getFile();
        System.setIn(new FileInputStream(pathFile));
        //Scanner fileScanner = new Scanner(new File(pathFile));
        Scanner input = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        while(input.hasNext()){
            a.add(input.nextInt());
        }
        int minK = a.get(a.size()-2);
        int maxK = a.get(a.size()-1);

        //int[] nums = a.subList(0, a.size() - 2).toArray(new int[]);
        int[] nums = a.subList(0, a.size() - 2).stream().mapToInt(Integer::intValue).toArray();
        System.out.println(countSubarrays(nums, minK, maxK));
    }





    public long countSubarrays(int[] nums, int minK, int maxK) {

        int[] a = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            a[i]=nums[i];
        }
        long ans = 0;
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        a[n]=2;
        int pre = 0;
        for(int i=0; i<n; i++){
            if(a[i] < minK) a[i]=-2;
            else if(a[i] == minK) a[i]=-1;
            else if(a[i] < maxK) a[i]=0;
            else if(a[i] == maxK) a[i]=1;
            else a[i]=2;

            if(Math.abs(a[i]) == 2){
                l[i]=0;
                pre=0;
            }
            else if(Math.abs(a[i])==1){
                l[i]=pre+1;
                pre=0;
            }
            else{
                pre++;
                l[i]=pre;
            }
        }
        pre = 0;
        for (int i = n-1; i >= 0; i--) {
            if(Math.abs(a[i])==2){
                r[i] = 0;
                pre = 0;
            }
            else{
                pre++;
                r[i]=pre;
            }
        }

        int ll = 0;
        int rr = 0;
        while(ll<n){
            while(ll<n && Math.abs(a[ll])!=1 ){
                ll++;
            }
            rr = ll;
            if(minK==maxK){
                ans += l[ll]*r[rr];
                ll++;
                continue;
            }
            while(rr<n && a[ll]+a[rr]!=0){
                rr++;
                if(Math.abs(a[rr])==2){
                    break;
                }
            }
            if(a[ll]+a[rr]==0){
                ans +=l[ll]*r[rr];
//                System.out.println(ll + " " + l[ll]*r[rr]);
            }
            ll++;
        }


        return ans;
    }

}


//35054 398719 945315 945315 820417 945315 35054 945315 171832 945315 35054 109750 790964 441974 552913 35054 945315