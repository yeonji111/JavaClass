package yeonji.submit01;

public class Submit03 {

    public static void main(String[] args) {

        String littlePrince = "나는 그때 아무것도 이해하지 못했어. 꽃의 말이 아닌 행동을 보고 판단했어야 했어. 내게 향기를 전해주고 즐거움을 주었는데, 그 꽃을 떠나지 말았어야 했어. 그 허영심 뒤에 가려진 따뜻한 마음을 보았어야 했는데, 그때 난 꽃을 제대로 사랑하기에는 아직 어렸던 거야.";

        String target = "허영심 뒤에 가려진 따뜻한 마음";

        System.out.println(littlePrince.length());
        System.out.println(littlePrince.indexOf("허"));
        System.out.println(littlePrince.indexOf("음") +1);
        System.out.println(littlePrince.substring(90,107));

        System.out.println("\n================ 타겟에 인덱스오브, 타켓의 길이 ===========\n");
                // 변수에 변경사항이 생기면 코드를 수정해야하므로 자동화하기 위해서

        System.out.println(littlePrince.indexOf(target));
        System.out.println(littlePrince.indexOf(target) + target.length());
    }

}
