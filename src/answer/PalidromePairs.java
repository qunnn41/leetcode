package answer;

import java.util.ArrayList;
import java.util.List;

public class PalidromePairs {
    /**
     * https://leetcode.com/problems/palindrome-pairs/
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length; ++j)
                if (i != j && isPalidrome(words[i] + words[j])) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                    System.out.println(list);
                }
        }

        return res;
    }

    private boolean isPalidrome(String str) {
        char[] array = str.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i ++] != array[j --])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalidromePairs().palindromePairs(new String[] {"djajbebdbg","iegccdeajdf","fcfa","bcd","dgb",
                "efedjiegbgaebdiibd","ij","gcagbhjfcjdeif","ifidc","dii","a","hec","eigbefebcbacg",
                "hhae","hghjda","ije","ehbhdhfddch","jhccfdiedacbiidgddb","djd","dcbhjihfidgbdicbae",
                "fbfjcejjjcgjjjee","g","bcii","ifeecacba","aicbgcgdfdfegiejifh","hgaegfgafahjg","cd",
                "jdfcfjbjgcdehcbjhig","ihgbihigfeggfjgdd","fb","gh","jhae","jhefdb","dfbgdaiaaaidcfe",
                "edadhd","facfcgacdfeidjce","bdjhbfhhhhaj","ddcjfai","acjaigbhjj","j","dfjbggffihjfjabhi","e","facdf",
                "d","df","gjhigjhjaedhc","ffceccjehjgbhaf","hjgj","cieiffi","gehbffadjfceh","ccgdicjbdgha",
                "icfcbcjfeejagiji","eiaade","acgjdhcd","fjbgbiehbdhe","aacbeahhf","h","hagdbgdbchj","cdigg",
                "aadhejbdbddieeehdfe","idgfhhcgbj","geeh","ejcjbaadidaff","cfea","cihfhgcjfjegehgifdaj","dbgd",
                "bhiigaejbghgccef","iadahbjhjddgjgg","bdajg","hgejiacfbcahjjh","cdifegdd","hedejefaagdaefficbga",
                "icdj","hfgfbcicfdjgga","cccjbjdaidfbf","i","hcbaegcfgicafbggc","b","ecdfgifggcddaf","ajbdaeedf",
                "gigiajicbchhd","hiiabefcb","dbdedbiaeeja","cdidefhhddfjhahcfg","agijej","hacieajdece","jbfdagjchjahdhadh",
                "jibgbjcgiaghbfjjjgjf","eifbabfcc","ifjhbefihhbba","iegfcddfijfjaegi","jbghcbdjieifcfg","gdhbbedebedc",
                "egjahjbdacgcibhihfa","jhegahdaejd","ehbaaceieieb","ijdacba","cabgibji","iifeadeeefffh","bdd","cjidibchbch",
                "edjeffeiecb","heeahh","iidhhd","diaibfie","abhddjfhfh","hegbihgghjgjg","abaeibcifdjbca","eaafiedgib","ehbihifjfbcjg",
                "dafbiihgfgfccfbig","bcaibfgifjbdd","adgjiccjbebfaej","cfgceacccjafjfeabab","giedgeegaehibajbhee","ediegj","cjhabdajad",
                "jeidgcahcejghgbiji","egabjgdfhga","iccgfd","igcfcde","dhdi","habbbejghjjdhg","ccijaaedecjcfg","f","efa","defebgfcigcjhfajgfb",
                "dgjeecejfhdichgafgci","cfjjifgadeae","gbjgifjbfjcadj","ic","cgfa","bajbjcfdhcbgfibe","ajagehhchcgaad","hhadg","fjbjeicajd",
                "badiegc","dfhja","ajeejjijcj","eihgfgdh","gcebfacb","afd","dgegehb","cidd","iiiefhhbbifidbhhif","edhja","fgjjicihe","hjcfdf",
                "ejhghijhjihhddceibdj","ghjj","hicdfdgg","fgbjbhjfjbajhjg","fiiicciaice","bjh","iagaecaeiejihhca","bfcdfadf","cfegfbjdbagid","gjde","bicfbefgbeh","biigcfbhfbhfde","fcdbfgejheghggccc","gbacfeia","hfbjacbdhdbbh","ghecibah","agcffhceiai","adjejehjgbhijchdaje","bde","ifidfjjcgegbcigci","hddgbhajhgbchb","hhcigbadjbeabacc","ejjgdifbfh","hgadidjaecdhjef","jggaeggbbdfeebhfghb","hfaidefb","ieafjagicd","bhigh","cchd","hb","ccciceghjcefhfffeg","bcjjadjibg","gjbehcih","diegdggcgfbdgegjibde","befcdgbjhgj","acidh","cjfie","icjecibhdjggj","debihgh","ja","eajfjdjihi","gcija","iiadjb","eacjad","gghif","ibbcj","dhdecb","fg","ibhcjaj","hjjdgbfdfgicbgcjdd","dcadidfefdgjbfchg","djagfjjgdajcfjcca","bicjgbidjbfebba","ehejeiijgjbffcd","jhbcceehehhedih","cggdgigfchidcjib","dhadfbj","dgeejjeejejgbif","cjcccjhj","eaecjbjhhhfjgd","cdgceaidcgcaeabjfja","gabbbbbdaebefaceefia","ghcabjbjjaheicjfidgj","defbb","igfbdggjjafdfjhjfbd","fh","aebdjh","adbfhhgi","iaiih","ejfbffddhcjhjdj","agbjhfgegdfcjbbe","dejejjbbfb","ieeiaa","cfehfhc","cccjffcgfggecdcfg","ghhdahjjdb","edgcfc","iggfbiiccibaejcjaj","bf","djjegbbiajbhiahghc","c","icjdjcjaahadihiegja","dhbcbgidhhgbj","jgahbdhf","fhgac","cajjjigc","chhhdbj","ejii","cda","hgjagegiahhdjcieejc","ifahbffeec","jciccghhffdfjbjbaff","cgbc","bbagegdecgf","dcicibbjhdaeafcdhadb","fcbaiegh","cdecgjeighhhhdhg","jhibcicicagijihd","iciehcihadfjh","fdefabffbda","baaficfeaeabfh","ahacfciigdjjihgad","iegbadf","dhgddfcecffjhh","cjfjbagjiahdf","gg","gjdjggheigiagjcgei","icbeidjdggbiicfh","cdigfafjgjahj","bccegii","eiagac","ffddajhbg","bdfajfbei","jbbffjceieebjcbdjhe","cjigcbdid","cgiegcce","fahcbhbiiheigg","fdgd","gffdffajdfbh","cagahjj","dbgbaaefbjghbjbfei","begd","fbjeahbefddjh","ieiicdhhdej","gabjf","ehcied","eejfeei","ihc","fjffhafejj","ifdjfdcfcbgaiifi","bfdegjgcd","ifcefgfijed","fghicabjhjg","egehdgdi","ebgigbdbbffhfbfhcbg","fbcfidbeheaafgchbb","fjjdhjbbj","fifaicjddjgaegdedi","fihbadgejchic","jgddh","hbhfceafbheidaecdc","ddifjgbiabhiicbbhg","dddajifcdgiffiidjci","eadabhcaeebgeahbajgc","adagagjgbghfdieabbeh","iajhdfabg","icib","agcebhcjcfbchfacbejd","ejfbicegjhieafbacig","fhgdadhjfdcfh","faabbicia","jibgjiihiiijajgejfge","jbibjaiefaahjcg","fhbahgihjdcfccciigeg","ihdjabheiaif","dgefage","fdfgdjajd","djc","idhcbgajigcehai","heh","dbheeabchabj","jjbccegf","hbhfgj","jcecjjbedffcjg","bgdfeejeidfbjccgi","gibihhjfigdid","bdgff","fbggehhcjfbijaghh","hfeeaiibebjgfdabaia","ah","jejefdbhghdgiaea","djiiggjccdg","edgabiheiicbdhf","hgdidjecgfiije","dfdahhdafg","dfjcf","abcfcggjbhgbi","cijebb","efejacbhfdhfj","gfjgafdcfeddiedhdiij","agccijdfeejhhacigag","fgjjeaahdgghbf","adgbceicbjecg","chf","dfchfbj","dijfgccgbj","bhjggj","iiggcgdafdadeaage","hce","gddbjaig","aedchjdcijbfed","jedb","egaaagjccgj","cbffecccaiegeafbegb","geecgi","ide","cfddhabcigg","eeahcicjgddhjec","bgfeef","habgdagjgdhaeg","gfddchgbjjgbedhcdea","ahgcajgfjag","igjfecafbef","egjbeicifejhfcgjbei","eeacfabffgejabhdbb","dhfgefcdb","baehfhfded","aejgificaehcfaahdc","bhjheffgcbdgb","fabdigifcfibdd","fejgggaiaigdege","jcgidjefc","fajh","gghagbjbb","hgciegiajabajejae","hcjegiajjgdac","gjcac","hjgjbeadccgddhj","eeedajehabcghcbhagjf","efdjac","jbbfdijgib","dibig","hhjhhjgjega","dhgjbfiibjgehifd","aaebgfdhfdeji","ijciaeddjadgf","ebjibiaddcbe","iggchaeefbjc","jedagaecejae","eebbbdffaghbdfdg","fdhfcehaggdgeeei","bibfbaehciigd","ffgbibdg","jaabcjchhgegaibhfa","fefhegbiaeij","jehiiadgijddbbejgcf","cgdeabafgficadecfaf","hadhbgbceejggggffcd","da","cadefcibjh","bcjachafecbecdiif","ahj","jb","dgbjjjjgbb","dgia","bfddiee","ahfcdfei","ijgacedbihfidjgha","bjecbbgeaedgcc","gjjfjdiddibjfej","gacgdeib","bhfifigaafe","efhj","iffgedgjic","ijicicgfeigjidid","ef","ccbbfdbaah","gbddfbbhge","ea","ehfhcijjh","cadfcaggcdha","hjgfacbgdhdghcbeef","bgafcfjhbdcbj","fbebgchhbjjjaibbdg","eicggaefgccgf","cbihg","jhfcdef","ba","abdjfdcfhchccfgb","ghgggebdgaaabjigj","cgifhdbceeihjg","ifajgibdghfacgj","ghcgfcecj","ahbjhagbjaibhgcjbabf","cbhibddcbbgbjgea","bjaaifibeeh","hiichg","bghjjh","iibdhjcaibfedaibhe","afhjfjcbd","ch","fgbcfcbjjfdhjadeigd","cbegifjjjcgaf","adcagdhbhad","cidgdfcjfig","feeccb","cacg","bgiieaehchfdgib","djdcaia","gghgaigihggcgchfhhc","becjbaahfghcgjhbh","jhbgiciccjdegbg","cbahbbjifcgh","hehdejjcgaaig","eha","ffcjefj","bhc","cbbajfgbeggfgjijahhg","fieefedagiijccdhiie","abdgaahc","ebjdjbjbjecchcff","hcfefhiejhfffaah","iddcicbdajeaba","aiafbca","eaacgbihahic","bdfacfajiejhfiifhgc","ggdijhgeggjgdfee","cacicgg","adajbd","ecjcbfacbiaaiijbi","gbbehha","gcdh","dcbbbd","efafgdbd","bdajhebeb","cfhiaf","hcjhi","chfa","efagj","jgfefcihea","hjfdjbhecgc","cjhfdbhdffg","digb","hd","jjhdie","hiihcbbaajfdee","eifbdjbagha","cbbg","fbjddeddafaff","eaheea","gefg","bccbiac","ghfjaeacgchgbf","hjgbfbjcaafbb","afbdebaiijiecbafi","gjef","ihf","ehbeabcijhi","hhh","hgbjiaega","jjidhgahbc","jicdhjiccai","gghhdfib","iffcgcdgbfgedah","fhhfcdghbaidcdeda","hea","hadhcadfhdefiidig","dcbbfagdaffhhhcae","fc","cabbfgcdijcfghdeiij","fjcf","gfehhihghi","jaficfjcaifgf","eieedadhf","ac","bibdejehefeafghagai","egehab","djhdjhbaejccdbgcebeg","hif","icbggfdcbfbje","gcicjfijbhbc","bi","ahfigiibebhj","bicbibb","fihebaibefddadadeaff","eihejgdjbjffdbji","bdjibbhcfgee","jhbhigdfeedhjighafec","dabahajef","gdddihiebddgb","eedigabjgc","gbjaahjcjiifjbfa","aebfjdebegfaaeha","ccddgfaidjeiceeifjb","jhggi","jjddfgggfjacfib","dcaaeegbdaeeiabej","fedgefbfg","dfj","aijggjgjdhejc","ehcfijfjfjfeaea","ie","jigffbhbeejddc","hadigadhiiegaejgehig","aecb","diihfdhfijffjfdfdba","ffc","ggicebdah","bbd","chgcjjheehbhbgf","fjeebijjchgfeig","hajf","hfgc","id","bjejbgihjgdig","beaidaehd","bd","haa","abeheccbgf","gfefihbef","gjfgdegjgcddb","iigigcgcjfjagfih","bjfjhcbbehcjidgaiid","fgabegcfhc","hedbecbfg","ieegeaggehd","jcjihfjhf","gjhgceccahigdehgjce","biaecabagjgfffgbf","fa","dcjigcejhh","bh"});
    }
}
