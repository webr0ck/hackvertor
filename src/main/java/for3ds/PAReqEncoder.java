package for3ds;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by j on 12/7/16.
 */
public class PAReqEncoder extends ByteModifier {
    public PAReqEncoder() {
        super("PAReq");
    }

    // GZIP Encode the bytes
    public byte[] modifyBytes(byte[] input) throws ModificationException{
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(input);
            URLSpecialCharEncoder uenc = new URLSpecialCharEncoder();
            Base64Encoder b64enc = new Base64Encoder();
            ZLIBEncoder zlenc = new ZLIBEncoder();

            byte[] zlibbytes = zlenc.modifyBytes(input);
            byte[] b64bytes = b64enc.modifyBytes(zlibbytes);
            byte[] output = uenc.modifyBytes(b64bytes);



            return output;
        } catch (Exception e) {
            String string =  new String(input, StandardCharsets.UTF_8);
            throw new ModificationException(e.getMessage()+" "+string);
        }
    }
}
