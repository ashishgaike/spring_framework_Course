package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.ProxyUtils;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class StudentRealmProxy extends com.fitzafful.gliveportal.db.Student
    implements RealmObjectProxy, StudentRealmProxyInterface {

    static final class StudentColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long nationalityIndex;
        long sexIndex;
        long pictureIndex;
        long boardingStatusIndex;
        long currentStatusIndex;
        long currentClassIndex;
        long dobIndex;
        long doaIndex;
        long schoolIndex;
        long school_idIndex;

        StudentColumnInfo(OsSchemaInfo schemaInfo) {
            super(12);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Student");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", objectSchemaInfo);
            this.nationalityIndex = addColumnDetails("nationality", objectSchemaInfo);
            this.sexIndex = addColumnDetails("sex", objectSchemaInfo);
            this.pictureIndex = addColumnDetails("picture", objectSchemaInfo);
            this.boardingStatusIndex = addColumnDetails("boardingStatus", objectSchemaInfo);
            this.currentStatusIndex = addColumnDetails("currentStatus", objectSchemaInfo);
            this.currentClassIndex = addColumnDetails("currentClass", objectSchemaInfo);
            this.dobIndex = addColumnDetails("dob", objectSchemaInfo);
            this.doaIndex = addColumnDetails("doa", objectSchemaInfo);
            this.schoolIndex = addColumnDetails("school", objectSchemaInfo);
            this.school_idIndex = addColumnDetails("school_id", objectSchemaInfo);
        }

        StudentColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new StudentColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final StudentColumnInfo src = (StudentColumnInfo) rawSrc;
            final StudentColumnInfo dst = (StudentColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.nationalityIndex = src.nationalityIndex;
            dst.sexIndex = src.sexIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.boardingStatusIndex = src.boardingStatusIndex;
            dst.currentStatusIndex = src.currentStatusIndex;
            dst.currentClassIndex = src.currentClassIndex;
            dst.dobIndex = src.dobIndex;
            dst.doaIndex = src.doaIndex;
            dst.schoolIndex = src.schoolIndex;
            dst.school_idIndex = src.school_idIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(12);
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("nationality");
        fieldNames.add("sex");
        fieldNames.add("picture");
        fieldNames.add("boardingStatus");
        fieldNames.add("currentStatus");
        fieldNames.add("currentClass");
        fieldNames.add("dob");
        fieldNames.add("doa");
        fieldNames.add("school");
        fieldNames.add("school_id");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private StudentColumnInfo columnInfo;
    private ProxyState<com.fitzafful.gliveportal.db.Student> proxyState;

    StudentRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (StudentColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.fitzafful.gliveportal.db.Student>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nationality() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nationalityIndex);
    }

    @Override
    public void realmSet$nationality(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nationalityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nationalityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nationalityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nationalityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sex() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sexIndex);
    }

    @Override
    public void realmSet$sex(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sexIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sexIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sexIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sexIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$picture() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pictureIndex);
    }

    @Override
    public void realmSet$picture(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pictureIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pictureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pictureIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pictureIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$boardingStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.boardingStatusIndex);
    }

    @Override
    public void realmSet$boardingStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.boardingStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.boardingStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.boardingStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.boardingStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$currentStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.currentStatusIndex);
    }

    @Override
    public void realmSet$currentStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.currentStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.currentStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.currentStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.currentStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$currentClass() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.currentClassIndex);
    }

    @Override
    public void realmSet$currentClass(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.currentClassIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.currentClassIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.currentClassIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.currentClassIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dob() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dobIndex);
    }

    @Override
    public void realmSet$dob(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dobIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dobIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dobIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dobIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$doa() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.doaIndex);
    }

    @Override
    public void realmSet$doa(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.doaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.doaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.doaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.doaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$school() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.schoolIndex);
    }

    @Override
    public void realmSet$school(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.schoolIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.schoolIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.schoolIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.schoolIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$school_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.school_idIndex);
    }

    @Override
    public void realmSet$school_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.school_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.school_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.school_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.school_idIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Student", 12, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nationality", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sex", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("boardingStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("currentStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("currentClass", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("dob", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("doa", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("school", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("school_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static StudentColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new StudentColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Student";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.fitzafful.gliveportal.db.Student createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.fitzafful.gliveportal.db.Student obj = null;
        if (update) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Student.class);
            StudentColumnInfo columnInfo = (StudentColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class), false, Collections.<String> emptyList());
                    obj = new io.realm.StudentRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.StudentRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Student.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.StudentRealmProxy) realm.createObjectInternal(com.fitzafful.gliveportal.db.Student.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final StudentRealmProxyInterface objProxy = (StudentRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("nationality")) {
            if (json.isNull("nationality")) {
                objProxy.realmSet$nationality(null);
            } else {
                objProxy.realmSet$nationality((String) json.getString("nationality"));
            }
        }
        if (json.has("sex")) {
            if (json.isNull("sex")) {
                objProxy.realmSet$sex(null);
            } else {
                objProxy.realmSet$sex((String) json.getString("sex"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                objProxy.realmSet$picture(null);
            } else {
                objProxy.realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("boardingStatus")) {
            if (json.isNull("boardingStatus")) {
                objProxy.realmSet$boardingStatus(null);
            } else {
                objProxy.realmSet$boardingStatus((String) json.getString("boardingStatus"));
            }
        }
        if (json.has("currentStatus")) {
            if (json.isNull("currentStatus")) {
                objProxy.realmSet$currentStatus(null);
            } else {
                objProxy.realmSet$currentStatus((String) json.getString("currentStatus"));
            }
        }
        if (json.has("currentClass")) {
            if (json.isNull("currentClass")) {
                objProxy.realmSet$currentClass(null);
            } else {
                objProxy.realmSet$currentClass((String) json.getString("currentClass"));
            }
        }
        if (json.has("dob")) {
            if (json.isNull("dob")) {
                objProxy.realmSet$dob(null);
            } else {
                objProxy.realmSet$dob((String) json.getString("dob"));
            }
        }
        if (json.has("doa")) {
            if (json.isNull("doa")) {
                objProxy.realmSet$doa(null);
            } else {
                objProxy.realmSet$doa((String) json.getString("doa"));
            }
        }
        if (json.has("school")) {
            if (json.isNull("school")) {
                objProxy.realmSet$school(null);
            } else {
                objProxy.realmSet$school((String) json.getString("school"));
            }
        }
        if (json.has("school_id")) {
            if (json.isNull("school_id")) {
                objProxy.realmSet$school_id(null);
            } else {
                objProxy.realmSet$school_id((String) json.getString("school_id"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.fitzafful.gliveportal.db.Student createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.fitzafful.gliveportal.db.Student obj = new com.fitzafful.gliveportal.db.Student();
        final StudentRealmProxyInterface objProxy = (StudentRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("nationality")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nationality((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nationality(null);
                }
            } else if (name.equals("sex")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sex((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sex(null);
                }
            } else if (name.equals("picture")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$picture((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$picture(null);
                }
            } else if (name.equals("boardingStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$boardingStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$boardingStatus(null);
                }
            } else if (name.equals("currentStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$currentStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$currentStatus(null);
                }
            } else if (name.equals("currentClass")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$currentClass((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$currentClass(null);
                }
            } else if (name.equals("dob")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$dob((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$dob(null);
                }
            } else if (name.equals("doa")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$doa((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$doa(null);
                }
            } else if (name.equals("school")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$school((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$school(null);
                }
            } else if (name.equals("school_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$school_id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$school_id(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.fitzafful.gliveportal.db.Student copyOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Student object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Student) cachedRealmObject;
        }

        com.fitzafful.gliveportal.db.Student realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.fitzafful.gliveportal.db.Student.class);
            StudentColumnInfo columnInfo = (StudentColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class);
            long pkColumnIndex = columnInfo.idIndex;
            String value = ((StudentRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.StudentRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.fitzafful.gliveportal.db.Student copy(Realm realm, com.fitzafful.gliveportal.db.Student newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.fitzafful.gliveportal.db.Student) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.fitzafful.gliveportal.db.Student realmObject = realm.createObjectInternal(com.fitzafful.gliveportal.db.Student.class, ((StudentRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        StudentRealmProxyInterface realmObjectSource = (StudentRealmProxyInterface) newObject;
        StudentRealmProxyInterface realmObjectCopy = (StudentRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$nationality(realmObjectSource.realmGet$nationality());
        realmObjectCopy.realmSet$sex(realmObjectSource.realmGet$sex());
        realmObjectCopy.realmSet$picture(realmObjectSource.realmGet$picture());
        realmObjectCopy.realmSet$boardingStatus(realmObjectSource.realmGet$boardingStatus());
        realmObjectCopy.realmSet$currentStatus(realmObjectSource.realmGet$currentStatus());
        realmObjectCopy.realmSet$currentClass(realmObjectSource.realmGet$currentClass());
        realmObjectCopy.realmSet$dob(realmObjectSource.realmGet$dob());
        realmObjectCopy.realmSet$doa(realmObjectSource.realmGet$doa());
        realmObjectCopy.realmSet$school(realmObjectSource.realmGet$school());
        realmObjectCopy.realmSet$school_id(realmObjectSource.realmGet$school_id());
        return realmObject;
    }

    public static long insert(Realm realm, com.fitzafful.gliveportal.db.Student object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Student.class);
        long tableNativePtr = table.getNativePtr();
        StudentColumnInfo columnInfo = (StudentColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((StudentRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((StudentRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$nationality = ((StudentRealmProxyInterface) object).realmGet$nationality();
        if (realmGet$nationality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nationalityIndex, rowIndex, realmGet$nationality, false);
        }
        String realmGet$sex = ((StudentRealmProxyInterface) object).realmGet$sex();
        if (realmGet$sex != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sexIndex, rowIndex, realmGet$sex, false);
        }
        String realmGet$picture = ((StudentRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        String realmGet$boardingStatus = ((StudentRealmProxyInterface) object).realmGet$boardingStatus();
        if (realmGet$boardingStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.boardingStatusIndex, rowIndex, realmGet$boardingStatus, false);
        }
        String realmGet$currentStatus = ((StudentRealmProxyInterface) object).realmGet$currentStatus();
        if (realmGet$currentStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currentStatusIndex, rowIndex, realmGet$currentStatus, false);
        }
        String realmGet$currentClass = ((StudentRealmProxyInterface) object).realmGet$currentClass();
        if (realmGet$currentClass != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currentClassIndex, rowIndex, realmGet$currentClass, false);
        }
        String realmGet$dob = ((StudentRealmProxyInterface) object).realmGet$dob();
        if (realmGet$dob != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
        }
        String realmGet$doa = ((StudentRealmProxyInterface) object).realmGet$doa();
        if (realmGet$doa != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.doaIndex, rowIndex, realmGet$doa, false);
        }
        String realmGet$school = ((StudentRealmProxyInterface) object).realmGet$school();
        if (realmGet$school != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.schoolIndex, rowIndex, realmGet$school, false);
        }
        String realmGet$school_id = ((StudentRealmProxyInterface) object).realmGet$school_id();
        if (realmGet$school_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.school_idIndex, rowIndex, realmGet$school_id, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Student.class);
        long tableNativePtr = table.getNativePtr();
        StudentColumnInfo columnInfo = (StudentColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Student object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Student) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((StudentRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((StudentRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$nationality = ((StudentRealmProxyInterface) object).realmGet$nationality();
            if (realmGet$nationality != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nationalityIndex, rowIndex, realmGet$nationality, false);
            }
            String realmGet$sex = ((StudentRealmProxyInterface) object).realmGet$sex();
            if (realmGet$sex != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sexIndex, rowIndex, realmGet$sex, false);
            }
            String realmGet$picture = ((StudentRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            }
            String realmGet$boardingStatus = ((StudentRealmProxyInterface) object).realmGet$boardingStatus();
            if (realmGet$boardingStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.boardingStatusIndex, rowIndex, realmGet$boardingStatus, false);
            }
            String realmGet$currentStatus = ((StudentRealmProxyInterface) object).realmGet$currentStatus();
            if (realmGet$currentStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currentStatusIndex, rowIndex, realmGet$currentStatus, false);
            }
            String realmGet$currentClass = ((StudentRealmProxyInterface) object).realmGet$currentClass();
            if (realmGet$currentClass != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currentClassIndex, rowIndex, realmGet$currentClass, false);
            }
            String realmGet$dob = ((StudentRealmProxyInterface) object).realmGet$dob();
            if (realmGet$dob != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
            }
            String realmGet$doa = ((StudentRealmProxyInterface) object).realmGet$doa();
            if (realmGet$doa != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.doaIndex, rowIndex, realmGet$doa, false);
            }
            String realmGet$school = ((StudentRealmProxyInterface) object).realmGet$school();
            if (realmGet$school != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.schoolIndex, rowIndex, realmGet$school, false);
            }
            String realmGet$school_id = ((StudentRealmProxyInterface) object).realmGet$school_id();
            if (realmGet$school_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.school_idIndex, rowIndex, realmGet$school_id, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.fitzafful.gliveportal.db.Student object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Student.class);
        long tableNativePtr = table.getNativePtr();
        StudentColumnInfo columnInfo = (StudentColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class);
        long pkColumnIndex = columnInfo.idIndex;
        String primaryKeyValue = ((StudentRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((StudentRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$nationality = ((StudentRealmProxyInterface) object).realmGet$nationality();
        if (realmGet$nationality != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nationalityIndex, rowIndex, realmGet$nationality, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nationalityIndex, rowIndex, false);
        }
        String realmGet$sex = ((StudentRealmProxyInterface) object).realmGet$sex();
        if (realmGet$sex != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sexIndex, rowIndex, realmGet$sex, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sexIndex, rowIndex, false);
        }
        String realmGet$picture = ((StudentRealmProxyInterface) object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        String realmGet$boardingStatus = ((StudentRealmProxyInterface) object).realmGet$boardingStatus();
        if (realmGet$boardingStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.boardingStatusIndex, rowIndex, realmGet$boardingStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.boardingStatusIndex, rowIndex, false);
        }
        String realmGet$currentStatus = ((StudentRealmProxyInterface) object).realmGet$currentStatus();
        if (realmGet$currentStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currentStatusIndex, rowIndex, realmGet$currentStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.currentStatusIndex, rowIndex, false);
        }
        String realmGet$currentClass = ((StudentRealmProxyInterface) object).realmGet$currentClass();
        if (realmGet$currentClass != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.currentClassIndex, rowIndex, realmGet$currentClass, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.currentClassIndex, rowIndex, false);
        }
        String realmGet$dob = ((StudentRealmProxyInterface) object).realmGet$dob();
        if (realmGet$dob != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dobIndex, rowIndex, false);
        }
        String realmGet$doa = ((StudentRealmProxyInterface) object).realmGet$doa();
        if (realmGet$doa != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.doaIndex, rowIndex, realmGet$doa, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.doaIndex, rowIndex, false);
        }
        String realmGet$school = ((StudentRealmProxyInterface) object).realmGet$school();
        if (realmGet$school != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.schoolIndex, rowIndex, realmGet$school, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.schoolIndex, rowIndex, false);
        }
        String realmGet$school_id = ((StudentRealmProxyInterface) object).realmGet$school_id();
        if (realmGet$school_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.school_idIndex, rowIndex, realmGet$school_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.school_idIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.fitzafful.gliveportal.db.Student.class);
        long tableNativePtr = table.getNativePtr();
        StudentColumnInfo columnInfo = (StudentColumnInfo) realm.getSchema().getColumnInfo(com.fitzafful.gliveportal.db.Student.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.fitzafful.gliveportal.db.Student object = null;
        while (objects.hasNext()) {
            object = (com.fitzafful.gliveportal.db.Student) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((StudentRealmProxyInterface) object).realmGet$id();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((StudentRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$nationality = ((StudentRealmProxyInterface) object).realmGet$nationality();
            if (realmGet$nationality != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nationalityIndex, rowIndex, realmGet$nationality, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nationalityIndex, rowIndex, false);
            }
            String realmGet$sex = ((StudentRealmProxyInterface) object).realmGet$sex();
            if (realmGet$sex != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sexIndex, rowIndex, realmGet$sex, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sexIndex, rowIndex, false);
            }
            String realmGet$picture = ((StudentRealmProxyInterface) object).realmGet$picture();
            if (realmGet$picture != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
            }
            String realmGet$boardingStatus = ((StudentRealmProxyInterface) object).realmGet$boardingStatus();
            if (realmGet$boardingStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.boardingStatusIndex, rowIndex, realmGet$boardingStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.boardingStatusIndex, rowIndex, false);
            }
            String realmGet$currentStatus = ((StudentRealmProxyInterface) object).realmGet$currentStatus();
            if (realmGet$currentStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currentStatusIndex, rowIndex, realmGet$currentStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.currentStatusIndex, rowIndex, false);
            }
            String realmGet$currentClass = ((StudentRealmProxyInterface) object).realmGet$currentClass();
            if (realmGet$currentClass != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.currentClassIndex, rowIndex, realmGet$currentClass, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.currentClassIndex, rowIndex, false);
            }
            String realmGet$dob = ((StudentRealmProxyInterface) object).realmGet$dob();
            if (realmGet$dob != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dobIndex, rowIndex, false);
            }
            String realmGet$doa = ((StudentRealmProxyInterface) object).realmGet$doa();
            if (realmGet$doa != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.doaIndex, rowIndex, realmGet$doa, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.doaIndex, rowIndex, false);
            }
            String realmGet$school = ((StudentRealmProxyInterface) object).realmGet$school();
            if (realmGet$school != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.schoolIndex, rowIndex, realmGet$school, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.schoolIndex, rowIndex, false);
            }
            String realmGet$school_id = ((StudentRealmProxyInterface) object).realmGet$school_id();
            if (realmGet$school_id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.school_idIndex, rowIndex, realmGet$school_id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.school_idIndex, rowIndex, false);
            }
        }
    }

    public static com.fitzafful.gliveportal.db.Student createDetachedCopy(com.fitzafful.gliveportal.db.Student realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.fitzafful.gliveportal.db.Student unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.fitzafful.gliveportal.db.Student();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.fitzafful.gliveportal.db.Student) cachedObject.object;
            }
            unmanagedObject = (com.fitzafful.gliveportal.db.Student) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        StudentRealmProxyInterface unmanagedCopy = (StudentRealmProxyInterface) unmanagedObject;
        StudentRealmProxyInterface realmSource = (StudentRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$nationality(realmSource.realmGet$nationality());
        unmanagedCopy.realmSet$sex(realmSource.realmGet$sex());
        unmanagedCopy.realmSet$picture(realmSource.realmGet$picture());
        unmanagedCopy.realmSet$boardingStatus(realmSource.realmGet$boardingStatus());
        unmanagedCopy.realmSet$currentStatus(realmSource.realmGet$currentStatus());
        unmanagedCopy.realmSet$currentClass(realmSource.realmGet$currentClass());
        unmanagedCopy.realmSet$dob(realmSource.realmGet$dob());
        unmanagedCopy.realmSet$doa(realmSource.realmGet$doa());
        unmanagedCopy.realmSet$school(realmSource.realmGet$school());
        unmanagedCopy.realmSet$school_id(realmSource.realmGet$school_id());

        return unmanagedObject;
    }

    static com.fitzafful.gliveportal.db.Student update(Realm realm, com.fitzafful.gliveportal.db.Student realmObject, com.fitzafful.gliveportal.db.Student newObject, Map<RealmModel, RealmObjectProxy> cache) {
        StudentRealmProxyInterface realmObjectTarget = (StudentRealmProxyInterface) realmObject;
        StudentRealmProxyInterface realmObjectSource = (StudentRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$nationality(realmObjectSource.realmGet$nationality());
        realmObjectTarget.realmSet$sex(realmObjectSource.realmGet$sex());
        realmObjectTarget.realmSet$picture(realmObjectSource.realmGet$picture());
        realmObjectTarget.realmSet$boardingStatus(realmObjectSource.realmGet$boardingStatus());
        realmObjectTarget.realmSet$currentStatus(realmObjectSource.realmGet$currentStatus());
        realmObjectTarget.realmSet$currentClass(realmObjectSource.realmGet$currentClass());
        realmObjectTarget.realmSet$dob(realmObjectSource.realmGet$dob());
        realmObjectTarget.realmSet$doa(realmObjectSource.realmGet$doa());
        realmObjectTarget.realmSet$school(realmObjectSource.realmGet$school());
        realmObjectTarget.realmSet$school_id(realmObjectSource.realmGet$school_id());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Student = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nationality:");
        stringBuilder.append(realmGet$nationality() != null ? realmGet$nationality() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sex:");
        stringBuilder.append(realmGet$sex() != null ? realmGet$sex() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{boardingStatus:");
        stringBuilder.append(realmGet$boardingStatus() != null ? realmGet$boardingStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currentStatus:");
        stringBuilder.append(realmGet$currentStatus() != null ? realmGet$currentStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currentClass:");
        stringBuilder.append(realmGet$currentClass() != null ? realmGet$currentClass() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dob:");
        stringBuilder.append(realmGet$dob() != null ? realmGet$dob() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{doa:");
        stringBuilder.append(realmGet$doa() != null ? realmGet$doa() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{school:");
        stringBuilder.append(realmGet$school() != null ? realmGet$school() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{school_id:");
        stringBuilder.append(realmGet$school_id() != null ? realmGet$school_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRealmProxy aStudent = (StudentRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aStudent.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aStudent.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aStudent.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
