package for3ds;
import java.nio.ByteBuffer;
import java.nio.charset.*;

/**
 * Created by j on 1/18/17.
 */
public class UTF8StringEncoder {
    //private final static  replacementChar = {(byte)0xEF, (byte)0xBF, (byte)0xBD};
    private final static CharsetDecoder utf8Decoder = Charset.forName("UTF-8")
            .newDecoder()
            .replaceWith("�")
            .onMalformedInput(CodingErrorAction.REPLACE)
            .onUnmappableCharacter(CodingErrorAction.REPLACE);

    public static String newUTF8String(byte[] input) {
        try {
            return utf8Decoder.decode(ByteBuffer.wrap(input)).toString();
        } catch (CharacterCodingException e) {
            Utils.printByteArray(input);
            return "";
        }
    }
}
